package com.sprint.mission.discodeit.dto;

import java.util.UUID;

public record UserStatusRequest(
        UUID userId,
        String statusMessage
){}
