package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.UserStatus;
import com.sprint.mission.discodeit.repository.UserStatusRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FileUserStatusRepository implements UserStatusRepository {
    private final List<UserStatus> userStatusList = new ArrayList<>();

    @Override
    public UserStatus save(UserStatus userStatus) {
        userStatusList.removeIf(status -> status.getId().equals(userStatus.getId()));
        userStatusList.add(userStatus);
        return userStatus;
    }

    @Override
    public Optional<UserStatus> findById(UUID id) {
        return userStatusList.stream()
                .filter(status -> status.getId().equals(id))
                .findFirst();
    }

    @Override
    public Optional<UserStatus> findByUserId(UUID userId) {
        return userStatusList.stream()
                .filter(status -> status.getUserId().equals(userId))
                .findFirst();
    }

    @Override
    public List<UserStatus> findAll() {
        return new ArrayList<>(userStatusList);
    }

    @Override
    public boolean existsById(UUID id) {
        return userStatusList.stream()
                .anyMatch(status -> status.getId().equals(id));
    }

    @Override
    public boolean existsByUserId(UUID userId) {
        return userStatusList.stream()
                .anyMatch(status -> status.getUserId().equals(userId));
    }

    @Override
    public void deleteById(UUID id) {
        userStatusList.removeIf(status -> status.getId().equals(id));
    }

    @Override
    public void deleteByUserId(UUID userId) {
        userStatusList.removeIf(status -> status.getUserId().equals(userId));
    }
}
