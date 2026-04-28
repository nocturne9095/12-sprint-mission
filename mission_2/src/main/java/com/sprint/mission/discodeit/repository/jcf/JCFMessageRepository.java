package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.util.*;

public class JCFMessageRepository implements MessageRepository {
    private final Map<UUID, Message> database = new HashMap<>();

    @Override
    public void save(Message message) {
        database.put(message.getId(), message);
    }

    @Override
    public Message find(UUID id) {
        return database.get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(UUID id) {
        database.remove(id);

    }
}
