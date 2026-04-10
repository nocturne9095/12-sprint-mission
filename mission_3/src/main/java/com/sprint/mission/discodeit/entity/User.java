package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.Instant;
import java.util.UUID;

public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    //
    private String username;
    private String email;
    private String password;

    public User(String username, String email, String password) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now().getEpochSecond();
        //
        this.username = username;
        this.email = email;
        this.password = password;
=======
import java.util.UUID;


public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final long createdAt;
    private long updatedAt;
    private String name;
    private String email;

    public User(String name, String email) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.name = name;
        this.email = email;
    }

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
        this.updatedAt = System.currentTimeMillis();
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }

    public UUID getId() {
        return id;
    }

<<<<<<< HEAD
    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
=======
    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public String getName() {
        return name;
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    }

    public String getEmail() {
        return email;
    }
<<<<<<< HEAD

    public String getPassword() {
        return password;
    }

    public void update(String newUsername, String newEmail, String newPassword) {
        boolean anyValueUpdated = false;
        if (newUsername != null && !newUsername.equals(this.username)) {
            this.username = newUsername;
            anyValueUpdated = true;
        }
        if (newEmail != null && !newEmail.equals(this.email)) {
            this.email = newEmail;
            anyValueUpdated = true;
        }
        if (newPassword != null && !newPassword.equals(this.password)) {
            this.password = newPassword;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.now().getEpochSecond();
        }
    }
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
