package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.UserService;

import java.util.List;
<<<<<<< HEAD
import java.util.NoSuchElementException;
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
import java.util.UUID;

public class BasicUserService implements UserService {
    private final UserRepository userRepository;

    public BasicUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
<<<<<<< HEAD
    public User create(String username, String email, String password) {
        User user = new User(username, email, password);
        return userRepository.save(user);
    }

    @Override
    public User find(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with id " + userId + " not found"));
=======
    public User create(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
        return user;
    }

    @Override
    public User find(UUID id) {
        return userRepository.find(id);
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
<<<<<<< HEAD
    public User update(UUID userId, String newUsername, String newEmail, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User with id " + userId + " not found"));
        user.update(newUsername, newEmail, newPassword);
        return userRepository.save(user);
    }

    @Override
    public void delete(UUID userId) {
        if (!userRepository.existsById(userId)) {
            throw new NoSuchElementException("User with id " + userId + " not found");
        }
        userRepository.deleteById(userId);
=======
    public User update(UUID id, String name, String email) {
        User existing = userRepository.find(id);
        if(existing != null) {
            existing.update(name, email);
            userRepository.save(existing);
            return existing;
        }
        return null;
    }

    @Override
    public void delete(UUID id) {
        userRepository.delete(id);

>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }
}
