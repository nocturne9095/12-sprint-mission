package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.Instant;
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
import java.util.UUID;

public class Channel implements Serializable {
    private static final long serialVersionUID = 1L;
<<<<<<< HEAD
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    //
    private ChannelType type;
    private String name;
    private String description;

    public Channel(ChannelType type, String name, String description) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now().getEpochSecond();
        //
        this.type = type;
        this.name = name;
        this.description = description;
=======

    private final UUID id;
    private final long createdAt;
    private long updatedAt;
    private String name;
    private String description;
    private final ChannelType type;


    public Channel(String name, String description, ChannelType type) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = this.createdAt;
        this.name = name;
        this.description = description;
        this.type = type;
    }

    public void update(String name, String description) {
        this.name = name;
        this.description = description;
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

    public ChannelType getType() {
        return type;
    }

=======
    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

<<<<<<< HEAD
    public void update(String newName, String newDescription) {
        boolean anyValueUpdated = false;
        if (newName != null && !newName.equals(this.name)) {
            this.name = newName;
            anyValueUpdated = true;
        }
        if (newDescription != null && !newDescription.equals(this.description)) {
            this.description = newDescription;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.now().getEpochSecond();
        }
    }
}
=======
    public ChannelType getType() {
        return type;
    }
}


>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
