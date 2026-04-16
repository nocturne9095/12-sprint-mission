package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class UserStatus implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final Instant createdAt;
    private Instant updatedAt;

    private final UUID userId;
    private Instant lastOnlineAt;

    public UserStatus(UUID userId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

        this.userId = userId;
        this.lastOnlineAt = Instant.now();
    }

    public void updateLastOnlineAt() {
        this.lastOnlineAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public boolean isOnline() {
        Instant fiveMinutesAgo = Instant.now().minusSeconds(300);
        return this.lastOnlineAt.isAfter(fiveMinutesAgo);
    }

}

