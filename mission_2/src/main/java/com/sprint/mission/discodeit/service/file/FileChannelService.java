package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.Channel;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.ChannelService;

import java.io.*;
import java.util.*;

public class FileChannelService implements ChannelService {
    private final String filePath = "channels.dat";

    private Map<UUID, Channel> readFile() {
        File file = new File(filePath);
        if(!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, Channel>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeFile(Map<UUID, Channel> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Channel create(Channel channel) {
        Map<UUID, Channel> data = readFile();
        data.put(channel.getId(), channel);
        writeFile(data);
        return channel;
    }

    @Override
    public Channel find(UUID id) {
        return readFile().get(id);
    }



    @Override
    public List<Channel> findAll() {
        return new ArrayList<>(readFile().values());
    }

    @Override
    public Channel update(UUID id, Channel channel) {
        Map<UUID, Channel> data = readFile();
        Channel existing = data.get(id);
        if(existing != null) {
            existing.update(channel.getName(), channel.getDescription());
            writeFile(data);
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Map<UUID, Channel> data = readFile();
        data.remove(id);
        writeFile(data);

    }
}
