package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.util.*;

public class JCFMessageRepository implements MessageRepository {
<<<<<<< HEAD
    private final Map<UUID, Message> data;

    public JCFMessageRepository() {
        this.data = new HashMap<>();
    }

    @Override
    public Message save(Message message) {
        this.data.put(message.getId(), message);
        return message;
    }

    @Override
    public Optional<Message> findById(UUID id) {
        return Optional.ofNullable(this.data.get(id));
=======
    private final Map<UUID, Message> database = new HashMap<>();

    @Override
    public void save(Message message) {
        database.put(message.getId(), message);
    }

    @Override
    public Message find(UUID id) {
        return database.get(id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }

    @Override
    public List<Message> findAll() {
<<<<<<< HEAD
        return this.data.values().stream().toList();
    }

    @Override
    public boolean existsById(UUID id) {
        return this.data.containsKey(id);
    }

    @Override
    public void deleteById(UUID id) {
        this.data.remove(id);
=======
        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(UUID id) {
        database.remove(id);

>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }
}
