package com.sprint.mission.discodeit.entity;

import java.util.UUID;

public class Channel {
    private final UUID id;
    private Long  createdAt;
    private Long updatedAt;
    private String username;
    private String description;


    public Channel(String username) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;

        this.username = username;
        this.description = description;
    }

    public UUID getId() {
        return id;
    }

    public Long getCreatedAt() {
        return createdAt;
    }

    public Long getUpdatedAt() {
        return updatedAt;
    }

    public String getUsername() {
        return username;
    }

    public String getDescription() {
        return description;
    }

    public void update(String name, String description) {
        this.username = username;
        this.description = this.description;
        this.updatedAt = System.currentTimeMillis();
    }

}


