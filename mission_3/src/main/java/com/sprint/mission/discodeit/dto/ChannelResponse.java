package com.sprint.mission.discodeit.dto;

import com.sprint.mission.discodeit.entity.ChannelType;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record ChannelResponse(
        UUID id,
        String name,
        String description,
        ChannelType type,
        LocalDateTime lastMessageAt,
        List<UUID> memberIds,
        Instant createdAt,
        Instant updatedAt
) {
}
