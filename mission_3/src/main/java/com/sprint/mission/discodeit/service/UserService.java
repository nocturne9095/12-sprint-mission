package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {
<<<<<<< HEAD
    User create(String username, String email, String password);
    User find(UUID userId);
    List<User> findAll();
    User update(UUID userId, String newUsername, String newEmail, String newPassword);
    void delete(UUID userId);
=======
    User create(User user);
    User find(UUID id);
    List<User> findAll();
    User update(UUID id, User user);
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
