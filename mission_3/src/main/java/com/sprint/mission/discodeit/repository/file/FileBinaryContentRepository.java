package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.repository.BinaryContentRepository;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class FileBinaryContentRepository implements BinaryContentRepository {
    private final Map<UUID, BinaryContent> store = new HashMap<>();

    @Override
    public BinaryContent save(BinaryContent binaryContent) {
        store.put(binaryContent.getId(), binaryContent);
        return binaryContent;
    }

    @Override
    public Optional<BinaryContent> findById(UUID id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<BinaryContent> findAllById(List<UUID> ids) {
        return store.values().stream()
                .filter(content -> ids.contains(content.getId()))
                .toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return store.containsKey(id);
    }

    @Override
    public void deleteById(UUID id) {
        store.remove(id);
    }

    @Override
    public void deleteAllByMessageId(UUID messageId) {
        store.values().removeIf(content -> content.getMessageId().equals(messageId)
                                                    && content.getMessageId() != null);
    }
}
