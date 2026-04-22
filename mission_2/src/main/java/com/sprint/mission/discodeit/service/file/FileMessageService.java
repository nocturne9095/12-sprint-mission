package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.ChannelService;
import com.sprint.mission.discodeit.service.MessageService;
import com.sprint.mission.discodeit.service.UserService;

import javax.imageio.IIOException;
import java.io.*;
import java.util.*;

public class FileMessageService implements MessageService {
    private final String filePath = "messages.dat";
    private final UserService userService;
    private final ChannelService channelService;

    public FileMessageService(UserService userService, ChannelService channelService) {
        this.userService = userService;
        this.channelService = channelService;
    }

    private Map<UUID, Message> readFile() {
        File file = new File(filePath);
        if(!file.exists()) {
            return new HashMap<>();
        }

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, Message>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeFile(Map<UUID, Message> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Message create(Message message) {
        if(userService.find(message.getUserId()) != null
        && channelService.find(message.getChannelId()) != null) {
            Map<UUID, Message> data = readFile();
            data.put(message.getId(), message);
            writeFile(data);
            System.out.println("메세지가 저장되었습니다.");
            return message;
        } else {
            System.out.println("저장에 실패했습니다.");
            return null;
        }
    }

    @Override
    public Message find(UUID id) {
        return readFile().get(id);
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(readFile().values());
    }

    @Override
    public Message update(UUID id, Message message) {
        Map<UUID, Message> data = readFile();
        Message existing = data.get(id);
        if (existing != null) {
            existing.update(message.getContent());
            writeFile(data);
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Map<UUID, Message> data = readFile();
        data.remove(id);
        writeFile(data);

    }
}
