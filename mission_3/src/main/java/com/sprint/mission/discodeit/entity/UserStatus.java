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
    private String statusMessage;
    private Instant lastOnlineAt;

    public UserStatus(UUID userId, String statusMessage) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();

        this.userId = userId;
        this.lastOnlineAt = Instant.now();
        this.statusMessage = statusMessage;
    }

    public void updateLastOnlineAt() {
        this.lastOnlineAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    public boolean isOnline() {
        Instant fiveMinutesAgo = Instant.now().minusSeconds(300);
        return this.lastOnlineAt.isAfter(fiveMinutesAgo);
    }

    public void update(String statusMessage) {
        this.statusMessage = statusMessage;
        this.updatedAt = Instant.now();
    }

}

