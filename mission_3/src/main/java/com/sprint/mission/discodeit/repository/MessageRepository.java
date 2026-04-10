package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {
    Message save(Message message);
    Optional<Message> findById(UUID id);
    List<Message> findAll();
    boolean existsById(UUID id);
    void deleteById(UUID id);
=======
import java.util.UUID;

public interface MessageRepository {
    void save(Message message);
    Message find(UUID id);
    List<Message> findAll();
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
