package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void createUser(User user);
    User read(UUID id);
    List<User> readAll();
    void updateUser(UUID id, User user);
    void deleteUser(UUID id);
}

