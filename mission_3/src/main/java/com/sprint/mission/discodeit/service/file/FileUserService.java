package com.sprint.mission.discodeit.service.file;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.io.*;
import java.util.*;

public class FileUserService implements UserService {
    private final String filePath = "users.dat";

    //역직렬화
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

    //직렬화
    private void writeFile(Map<UUID, User> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public User create(User user) {
        Map<UUID, User> data = readFile();
        data.put(user.getId(), user);
        writeFile(data);
        return user;
    }

    @Override
    public User find(UUID id) {
        return readFile().get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(readFile().values());
    }

    @Override
    public User update(UUID id, User user) {
        Map<UUID, User> data = readFile();
        User existing = data.get(id);
        if(existing != null) {
            existing.update(user.getName(), user.getEmail());
            writeFile(data);
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        Map<UUID, User> data = readFile();
        data.remove(id);
        writeFile(data);

    }
}
