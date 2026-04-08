package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.UserService;

import java.util.*;

public class JCFUserService implements UserService {
    private final Map<UUID, User> data;

    public JCFUserService(Map<UUID, User> data) {
        this.data = data;
    }

    @Override
    public User create(User user) {
        data.put(user.getId(), user);
        return user;
    }

    @Override
    public User find(UUID id) {
        return data.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<User>(data.values());
    }

    @Override
    public User update(UUID id, User user) {
        User existingUser = data.get(id);
        if(existingUser != null) {
            existingUser.update(user.getName(), user.getEmail());
            return existingUser;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        data.remove(id);
    }
}
