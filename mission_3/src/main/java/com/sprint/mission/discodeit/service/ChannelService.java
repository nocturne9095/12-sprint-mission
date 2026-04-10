package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.Channel;
<<<<<<< HEAD
import com.sprint.mission.discodeit.entity.ChannelType;
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8

import java.util.List;
import java.util.UUID;

public interface ChannelService {
<<<<<<< HEAD
    Channel create(ChannelType type, String name, String description);
    Channel find(UUID channelId);
    List<Channel> findAll();
    Channel update(UUID channelId, String newName, String newDescription);
    void delete(UUID channelId);
=======
    Channel create(Channel channel);
    Channel find(UUID id);
    List<Channel> findAll();
    Channel update(UUID id, Channel channel);
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
