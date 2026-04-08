package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.ChannelType;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.service.ChannelService;

import java.util.List;
import java.util.UUID;

public class BasicChannelService implements ChannelService {
    private final ChannelRepository channelRepository;

    public BasicChannelService(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel create(String name, String description, ChannelType type)  {
        Channel channel = new Channel(name, description, type);
        channelRepository.save(channel);
        return channel;
    }

    @Override
    public Channel find(UUID id) {
        return channelRepository.find(id);
    }

    @Override
    public List<Channel> findAll() {
        return channelRepository.findAll();
    }

    @Override
    public Channel update(UUID id, String name, String description) {
        Channel existing = channelRepository.find(id);
        if(existing != null) {
            existing.update(name, description);
            channelRepository.save(existing);
            return existing;
        }
        System.out.println("수정하려는 채널을 찾을 수 없습니다.");
        return null;
    }

    @Override
    public void delete(UUID id) {
        channelRepository.delete(id);
        System.out.println("채널 삭제 : " + id);

    }
}
