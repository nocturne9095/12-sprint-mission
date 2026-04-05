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
            Object obj = ois.readObject();
            if (obj instanceof Map) {
                return (Map<UUID, User>) obj;
            }
            return new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            return new HashMap<>();
        }
    }

    private void writeFile(Map<UUID, User> data) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))){
            oos.writeObject(data);
        } catch (IOException e) {
            throw new RuntimeException("파일 쓰기 실패", e);
        }
    }

    @Override
    public void save(User user) {
        Map<UUID, User> data = readFile();
        data.put(user.getId(), user);
        writeFile(data);
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
    public void delete(UUID id) {
        Map<UUID, User> data = readFile();
        data.remove(id);
        writeFile(data);
    }
}
