package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final Instant createdAt;
    private Instant updatedAt;
    //
    private String username;
    private String email;
    private String password;

    private UUID profileId;

    public User(String username, String email, String password, UUID profileId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        //
        this.username = username;
        this.email = email;
        this.password = password;
        this.profileId = profileId;
    }

    public void updateUsername(String newUsername) {
        if (newUsername != null && !newUsername.isBlank() && !newUsername.equals(this.username)) {
            this.username = newUsername;
            this.updatedAt = Instant.now();
        }
    }

    public void updateProfile(UUID newProfileId) {
        this.profileId = newProfileId;
        this.updatedAt = Instant.now();
    }
}
