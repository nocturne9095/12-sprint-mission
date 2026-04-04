package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.*;

public class JCFMessageService implements MessageService {
    private final Map<UUID, Message> data;

    public JCFMessageService() {
        this.data = new HashMap<>();
    }

    @Override
    public void createMessage(Message message) {
        data.put(message.getId(), message);
    }

    @Override
    public Message read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Message> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void updateMessage(UUID id, Message updateMessage) {
            Message existingMessage = data.get(id);
            if (existingMessage != null) {
                existingMessage.update(updateMessage.getContent());
            }
    }

    @Override
    public void deleteMessage(UUID id) {
        data.remove(id);
    }
}
