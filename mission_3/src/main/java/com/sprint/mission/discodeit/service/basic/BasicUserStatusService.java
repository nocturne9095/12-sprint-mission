package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.dto.UserStatusRequest;
import com.sprint.mission.discodeit.dto.UserStatusResponse;
import com.sprint.mission.discodeit.dto.UserStatusUpdateRequest;
import com.sprint.mission.discodeit.entity.UserStatus;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.repository.UserStatusRepository;
import com.sprint.mission.discodeit.service.UserStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class BasicUserStatusService implements UserStatusService {
    private final UserStatusRepository userStatusRepository;
    private final UserRepository userRepository;

    @Override
    public UserStatusResponse create(UserStatusRequest request) {
        if (!userRepository.existsById(request.userId())) {
            throw new NoSuchElementException("User not found with id " + request.userId());
        }

        if(userStatusRepository.existsByUserId(request.userId())) {
            throw new IllegalStateException("UserStatus already exists for user");
        }

        UserStatus userStatus = new UserStatus(request.userId(), request.statusMessage());
        return convertToResponse(userStatusRepository.save(userStatus));
    }

    @Override
    public UserStatusResponse find(UUID id) {
        return userStatusRepository.findById(id)
                .map(this::convertToResponse)
                .orElseThrow(() -> new NoSuchElementException("UserStatus not found with id " + id));
    }

    @Override
    public List<UserStatusResponse> findAll() {
        return userStatusRepository.findAll().stream()
                .map(this::convertToResponse)
                .toList();
    }

    @Override
    public UserStatusResponse update(UserStatusUpdateRequest request) {
        UserStatus userStatus = userStatusRepository.findById(request.id())
                .orElseThrow(() -> new NoSuchElementException("UserStatus not found with id " + request.id()));

        userStatus.update(request.statusMessage());
        return convertToResponse(userStatusRepository.save(userStatus));

    }

    @Override
    public UserStatusResponse updateByUserId(UUID userId, UserStatusUpdateRequest request) {
        UserStatus userStatus = userStatusRepository.findByUserId(userId)
                .orElseThrow(() -> new NoSuchElementException("UserStatus not found for user with id " + userId));

        userStatus.update(request.statusMessage());
        return convertToResponse(userStatusRepository.save(userStatus));
    }

    @Override
    public void delete(UUID id) {
        if (!userStatusRepository.existsById(id)) {
            throw new NoSuchElementException("UserStatus not found with id " + id);
        }
        userStatusRepository.deleteById(id);
    }


    private UserStatusResponse convertToResponse(UserStatus userStatus) {
        return new UserStatusResponse(
                userStatus.getId(),
                userStatus.getUserId(),
                userStatus.getStatusMessage()
        );
    }
}
