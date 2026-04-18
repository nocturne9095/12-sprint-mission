package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.ReadStatus;
import com.sprint.mission.discodeit.repository.ReadStatusRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class FileReadStatusRepository implements ReadStatusRepository {
    private final List<ReadStatus> readStatusList = new ArrayList<>();

    @Override
    public ReadStatus save(ReadStatus readStatus) {
        readStatusList.removeIf(status -> status.getId().equals(readStatus.getId()));
        readStatusList.add(readStatus);
        return readStatus;
    }

    @Override
    public Optional<ReadStatus> findById(UUID id) {
        return readStatusList.stream()
                .filter(status -> status.getId().equals(id))
                .findFirst();
    }

    @Override
    public boolean existsById(UUID id) {
        return readStatusList.stream()
                .anyMatch(status -> status.getId().equals(id));
    }

    @Override
    public boolean existsByUserIdAndChannelId(UUID userId, UUID channelId) {
        return findByUserIdAndChannelId(userId, channelId).isPresent();
    }

    @Override
    public void deleteById(UUID id) {
        readStatusList.removeIf(status -> status.getId().equals(id));
    }

    @Override
    public List<ReadStatus> findAllByUserId(UUID userId) {
        return  readStatusList.stream()
                .filter(status -> status.getUserId().equals(userId))
                .toList();
    }

    @Override
    public Optional<ReadStatus> findByUserIdAndChannelId(UUID userId, UUID channelId) {
        return readStatusList.stream()
                .filter(status -> status.getUserId().equals(userId) && status.getChannelId().equals(channelId))
                .findFirst();
    }

    @Override
    public List<ReadStatus> findByChannelId(UUID channelId) {
        return readStatusList.stream()
                .filter(status -> status.getChannelId().equals(channelId))
                .toList();
    }

    @Override
    public void deleteByChannelId(UUID channelId) {
        readStatusList.removeIf(status -> status.getChannelId().equals(channelId));
    }
}
