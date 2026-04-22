package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.repository.ChannelRepository;

import java.util.*;

public class JCFChannelRepository implements ChannelRepository {
    private final Map<UUID, Channel> database = new HashMap<>();

    @Override
    public void save(Channel channel) {
        database.put(channel.getId(), channel);
    }

    @Override
    public Channel find(UUID id) {
        return database.get(id);
    }

    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(UUID id) {
        database.remove(id);

    }
}
