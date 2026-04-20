package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JCFMessageService implements MessageService {
    private final Map<UUID, Message> data;
    private final UserService userService;
    private final ChannelService channelService;

    public JCFMessageService(Map<UUID, Message> data, UserService userService, ChannelService channelService) {
        this.data = data;
        this.userService = userService;
        this.channelService = channelService;
    }

    @Override
    public Message create(Message message) {
        //심화
        if(userService.find(message.getUserId()) != null
                && channelService.find(message.getChannelId()) != null) {
            data.put(message.getId(), message);
        } else {
            System.out.println("User not found");
        }
        return message;

    }

    @Override
    public Message find(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public Message update(UUID id, Message message) {
        Message existing = data.get(id);
        if(existing != null) {
            existing.update(message.getContent());
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}
