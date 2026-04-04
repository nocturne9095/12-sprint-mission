package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data;

public  JCFUserService() {
    this.data = new HashMap<>();
}

    @Override
    public void createUser(User user) {
        data.put(user.getId(), user);
    }

    @Override
    public User read(UUID id) {
        return data.get(id);
    }

    @Override
    public List<User> readAll() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void updateUser(UUID id, User updateUser) {
    User existingUser = data.get(id);
    if (existingUser != null) {
        existingUser.update(updateUser.getUsername(), updateUser.getEmail(),
                updateUser.getPassword(), updateUser.getNickName());
        }
    }

    @Override
    public void deleteUser(UUID id) {
        data.remove(id);
    }
}
