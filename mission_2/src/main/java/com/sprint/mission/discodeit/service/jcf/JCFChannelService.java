package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class JCFChannelService implements ChannelService {
    private final Map<UUID, Channel> data;

    public JCFChannelService(Map<UUID, Channel> data) {
        this.data = data;
    }

    @Override
    public Channel create(Channel channel) {
        data.put(channel.getId(), channel);
        return channel;
    }

    @Override
    public Channel find(UUID id) {
        return data.get(id);
    }

    @Override
    public List<Channel> findAll() {
        return new ArrayList<Channel>(data.values());
    }

    @Override
    public Channel update(UUID id, Channel channel) {
        Channel existingChannel = data.get(id);
        if (existingChannel != null) {
            existingChannel.update(channel.getName(), channel.getDescription());
            return existingChannel;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);

    }
}
