package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.ChannelRepository;
import com.sprint.mission.discodeit.repository.MessageRepository;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.MessageService;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
import java.util.Optional;
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
import java.util.UUID;

public class BasicMessageService implements MessageService {
    private final MessageRepository messageRepository;
<<<<<<< HEAD
    //
    private final ChannelRepository channelRepository;
    private final UserRepository userRepository;

    public BasicMessageService(MessageRepository messageRepository, ChannelRepository channelRepository, UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.channelRepository = channelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Message create(String content, UUID channelId, UUID authorId) {
        if (!channelRepository.existsById(channelId)) {
            throw new NoSuchElementException("Channel not found with id " + channelId);
        }
        if (!userRepository.existsById(authorId)) {
            throw new NoSuchElementException("Author not found with id " + authorId);
        }

        Message message = new Message(content, channelId, authorId);
        return messageRepository.save(message);
    }

    @Override
    public Message find(UUID messageId) {
        return messageRepository.findById(messageId)
                .orElseThrow(() -> new NoSuchElementException("Message with id " + messageId + " not found"));
=======
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
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }

    @Override
    public List<Message> findAll() {
        return messageRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public Message update(UUID messageId, String newContent) {
        Message message = messageRepository.findById(messageId)
                .orElseThrow(() -> new NoSuchElementException("Message with id " + messageId + " not found"));
        message.update(newContent);
        return messageRepository.save(message);
    }

    @Override
    public void delete(UUID messageId) {
        if (!messageRepository.existsById(messageId)) {
            throw new NoSuchElementException("Message with id " + messageId + " not found");
        }
        messageRepository.deleteById(messageId);
=======
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

>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }
}
