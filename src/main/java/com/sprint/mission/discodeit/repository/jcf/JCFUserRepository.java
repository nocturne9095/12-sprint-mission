package com.sprint.mission.discodeit.repository.jcf;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;

import java.util.*;

public class JCFUserRepository implements UserRepository {
    private final Map<UUID, User> database = new HashMap<>();

    @Override
    public void save(User user) {
        database.put(user.getId(), user);
    }

    @Override
    public User find(UUID id) {
        return database.get(id);
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public void delete(UUID id) {
        database.remove(id);

    }
}
