package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.Channel;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.UUID;

public interface ChannelRepository {
    Channel save(Channel channel);
    Optional<Channel> findById(UUID id);
    List<Channel> findAll();
    boolean existsById(UUID id);
    void deleteById(UUID id);
=======
import java.util.UUID;

public interface ChannelRepository {
    void save(Channel channel);
    Channel find(UUID id);
    List<Channel> findAll();
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
