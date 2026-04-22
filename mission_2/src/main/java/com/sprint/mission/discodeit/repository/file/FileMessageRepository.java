package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.repository.MessageRepository;

import java.io.*;
import java.util.*;

public class FileMessageRepository implements MessageRepository {
    private final String filePath = "messages.dat";

    private Map<UUID, Message> readFile() {
        File file = new File(filePath);
        if(!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
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
    public void save(Message message) {
        Map<UUID, Message> data = readFile();
        data.put(message.getId(), message);
        writeFile(data);
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
    public void delete(UUID id) {
        Map<UUID, Message> data = readFile();
        data.remove(id);
        writeFile(data);

    }
}
