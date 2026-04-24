package com.sprint.mission.discodeit.controller;


import com.sprint.mission.discodeit.dto.data.UserDto;
import com.sprint.mission.discodeit.dto.request.LoginRequest;
import com.sprint.mission.discodeit.dto.request.UserCreateRequest;
import com.sprint.mission.discodeit.dto.request.UserUpdateRequest;
import com.sprint.mission.discodeit.entity.User;
import com.sprint.mission.discodeit.service.AuthService;
import com.sprint.mission.discodeit.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthService authService;

    public UserController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    //사용자 조회
    @RequestMapping(method = RequestMethod.GET)
    public List<UserDto> getAllUsers() {
        return userService.findAll();
    }

    //사용자 등록
    @RequestMapping(method = RequestMethod.POST)
    public UserDto createUser(@RequestBody UserCreateRequest request) {
        return userService.create(request, java.util.Optional.empty());
    }

    //사용자 수정
    @RequestMapping(value = "/{userId}", method = RequestMethod.PATCH)
    public UserDto updateUser (
            @PathVariable UUID userId,
            @RequestBody UserUpdateRequest request
    ){
        User updateUser = userService.update(userId, request, java.util.Optional.empty());

        return new UserDto(
                updateUser.getId(),
                updateUser.getCreatedAt(),
                updateUser.getUpdatedAt(),
                updateUser.getUsername(),
                updateUser.getEmail(),
                updateUser.getProfileId(),
                null
        );
    }

    @RequestMapping(value = "/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable UUID userId) {
        userService.delete(userId);
    }

    @RequestMapping(value = "/{userId}/online", method = RequestMethod.POST)
    public void updateOnlineStatus(@PathVariable UUID userId) {
        userService.updateUserStatus(userId);
    }


    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
