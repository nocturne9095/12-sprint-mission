package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.repository.MessageRepository;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.List;
import java.util.UUID;

public class BasicMessageService implements MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChannelRepository channelRepository;

    public BasicMessageService(MessageRepository messageRepo, UserRepository userRepo, ChannelRepository channelRepo) {
        this.messageRepository = messageRepo;
        this.userRepository = userRepo;
        this.channelRepository = channelRepo;
    }

    @Override
    public Message create(String content, UUID authorId, UUID channelId) {
        if(userRepository.find(authorId) != null
        && channelRepository.find(channelId) != null) {
            Message newMsg = new Message(content, authorId, channelId);
            messageRepository.save(newMsg);
            return newMsg;
        }
        System.out.println("존재하지 않습니다.");
        return null;

    }

    @Override
    public Message find(UUID id) {
        return messageRepository.find(id);
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
    public Message update(UUID id, String content) {
        Message existing = messageRepository.find(id);
        if (existing != null) {
            existing.update(content);
            messageRepository.save(existing);
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        messageRepository.delete(id);

    }
}
