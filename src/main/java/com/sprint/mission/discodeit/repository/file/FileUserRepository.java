package com.sprint.mission.discodeit.repository.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;

import java.io.*;
import java.util.*;

public class FileUserRepository implements UserRepository {
    private final String filePath = "users.dat";

    private Map<UUID, User> readFile() {
        File file = new File(filePath);
        if(!file.exists()) {
            return new HashMap<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (Map<UUID, User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeFile(Map<UUID, User> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new ObjectOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void save(User user) {
        Map<UUID, User> data = readFile();
        data.put(user.getId(), user);
        writeFile(data);
    }

    @Override
    public User fid(UUID id) {
        return readFile().get(id);
    }

    @Override
    public List<User> finaAll() {
        return new ArrayList<>(readFile().values());
    }

    @Override
    public void delete(UUID id) {
        Map<UUID, User> data = readFile();
        data.remove(id);
        writeFile(data);
    }
}
