package com.sprint.mission.discodeit.repository;

import com.sprint.mission.discodeit.entity.User;

import java.util.List;
<<<<<<< HEAD
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    List<User> findAll();
    boolean existsById(UUID id);
    void deleteById(UUID id);
=======
import java.util.UUID;

public interface UserRepository {
    void save(User user);
    User find(UUID id);
    List<User> findAll();
    void delete(UUID id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
