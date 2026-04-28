package com.sprint.mission.discodeit.dto;

import java.util.List;
import java.util.UUID;

public record MessageRequest(
        String content,
        UUID channelId,
        UUID authorId,
        List<UUID> binaryContentIds
) {
}
