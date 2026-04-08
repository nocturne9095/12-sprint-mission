package com.sprint.mission.discodeit.service.basic;

import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.repository.UserRepository;
import com.sprint.mission.discodeit.service.UserService;

import java.util.List;
import java.util.UUID;

public class BasicUserService implements UserService {
    private final UserRepository userRepository;

    public BasicUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(String name, String email) {
        User user = new User(name, email);
        userRepository.save(user);
        return user;
    }

    @Override
    public User find(UUID id) {
        return userRepository.find(id);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
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

    }
}
