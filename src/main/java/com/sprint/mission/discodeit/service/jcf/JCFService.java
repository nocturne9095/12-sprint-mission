package com.sprint.mission.discodeit.service.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static java.util.Locale.filter;

public class JCFService implements Service {
    private final List<User> data;

    public JCFService() {
        data = new ArrayList<>();
    }

    @Override
    public User save(User user) {
        data.add(user);
        return user;
    }

    @Override
    public User findById(UUID id) {
        for (User user : data) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        return data;
    }
}
