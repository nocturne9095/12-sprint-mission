package com.sprint.mission.discodeit.dto;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record MessageResponse(
        UUID id,
        String content,
        UUID ChannelId,
        UUID authorId,
        Instant createdAt,
        Instant updatedAt
) {
}
