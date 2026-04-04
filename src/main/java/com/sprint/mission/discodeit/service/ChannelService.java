package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
import java.util.UUID;

public interface ChannelService {
    void createChannel(Channel channel);
    Channel read(UUID id);
    List<Channel> readAll();
    void updateChannel(UUID id,Channel channel);
    void deleteChannel(UUID id);
}
