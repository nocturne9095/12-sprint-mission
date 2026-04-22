package com.sprint.mission.discodeit.dto;

public record UserUpdateRequest(
        String username,
        UserCreateRequest.ProfileImageRequest profileImage
) {
}
