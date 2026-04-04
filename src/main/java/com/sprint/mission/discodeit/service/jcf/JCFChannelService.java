package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data;

    public JCFChannelService() {
        this.data = new ConcurrentHashMap<>();
    }

    @Override
    public void createChannel(Channel channel) {
        data.put(channel.getId(), channel);
    }

    @Override
    public Channel read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Channel> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void updateChannel(UUID id, Channel updateChannel) {
        Channel existingChannel = data.get(id);
        if (existingChannel != null) {
           existingChannel.update(updateChannel.getUsername(), updateChannel.getDescription());

        }
    }

    @Override
    public void deleteChannel(UUID id) {
        data.remove(id);
    }
}
