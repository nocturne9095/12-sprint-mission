package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {
<<<<<<< HEAD
    Message create(String content, UUID channelId, UUID authorId);
    Message find(UUID messageId);
    List<Message> findAll();
    Message update(UUID messageId, String newContent);
    void delete(UUID messageId);
=======
    Message create(Message message);
    Message find(UUID id);
    List<Message> findAll();
    Message update(UUID id, Message message);
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
