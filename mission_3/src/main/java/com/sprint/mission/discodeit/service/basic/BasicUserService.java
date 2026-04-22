package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.UserCreateRequest;
import com.sprint.mission.discodeit.dto.UserResponse;
import com.sprint.mission.discodeit.dto.UserUpdateRequest;
import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.entity.UserStatus;
import com.sprint.mission.discodeit.repository.BinaryContentRepository;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.repository.UserStatusRepository;
import com.sprint.mission.discodeit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicUserService implements UserService {
    private final UserRepository userRepository;
    private final UserStatusRepository userStatusRepository;
    private final BinaryContentRepository binaryContentRepository;


    @Override
    public UserResponse create(UserCreateRequest request) {
        //username과 email 중복 확인
        if(userRepository.existsByUsername(request.username())) {
            throw new IllegalArgumentException("중복된 이름");
        }
        if(userRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("중복된 이메일");
        }

        //선택적 프로필 이미지 등록
        UUID profileImageId = null;
        if(request.profileImage() != null) {
            BinaryContent profile = new BinaryContent(
                    request.profileImage().fileName(),
                    request.profileImage().data()
            );
            binaryContentRepository.save(profile);
            profileImageId = profile.getId();
        }

        User user = new User(request.username(), request.email(), request.password(), profileImageId);
        userRepository.save(user);

        UserStatus status = new UserStatus(user.getId(), "");
        userStatusRepository.save(status);

        return convertToResponse(user, status);
    }


    @Override
    public UserResponse findById(UUID id) {
        User user = userRepository.findById(id).orElseThrow();
        UserStatus status = userStatusRepository.findByUserId(id).orElseThrow();
        return convertToResponse(user, status);
    }

    @Override
    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(user -> {
            UserStatus status = userStatusRepository.findByUserId(user.getId()).orElseThrow();
            return convertToResponse(user, status);
                }
                )
                .toList();
    }


    @Override
    public UserResponse update(UUID id, UserUpdateRequest request) {
        //기존 유저
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 사용자입니다."));

        //유저네임 업데이트
        if(request.username() != null) {
            user.updateUsername(request.username());
        }

        //프로필 이미지 업데이트
        if(request.profileImage() != null) {
            BinaryContent newProfile = new BinaryContent(
                    request.profileImage().fileName(),
                    request.profileImage().data()
            );
            binaryContentRepository.save(newProfile);

            //프로필 ID 교체
            user.updateProfile(newProfile.getId());
        }

        userRepository.save(user);

        UserStatus status = userStatusRepository.findByUserId(id)
                .orElseThrow(() -> new IllegalStateException("사용자 정보가 없습니다."));

        return convertToResponse(user, status);
    }

    @Override
    public void delete(UUID id) {
        User user = userRepository.findById(id).orElseThrow();

        if(user.getProfileId() != null) {
            binaryContentRepository.deleteById(user.getProfileId());
        }

        userStatusRepository.deleteByUserId(id);
        userRepository.deleteById(id);
    }

    //공통 변환 매서드
    private UserResponse convertToResponse(User user,UserStatus status) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getUsername(),
                status.isOnline(),          //UserStatus 내부의 5분 체크
                user.getProfileId()
        );
    }
}
