package com.sprint.mission.discodeit.entity;

import java.io.Serializable;
<<<<<<< HEAD
import java.time.Instant;
=======
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
import java.util.UUID;

public class Message implements Serializable {
    private static final long serialVersionUID = 1L;

<<<<<<< HEAD
    private UUID id;
    private Long createdAt;
    private Long updatedAt;
    //
    private String content;
    //
    private UUID channelId;
    private UUID authorId;

    public Message(String content, UUID channelId, UUID authorId) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now().getEpochSecond();
        //
        this.content = content;
        this.channelId = channelId;
        this.authorId = authorId;
=======
    private final UUID id;
    private final long createdAt;
    private long updatedAt;
    private String content;
    private final UUID userId;
    private final UUID channelId;

    public Message(String content, UUID userId, UUID channelId) {
        this.id = UUID.randomUUID();
        this.createdAt = System.currentTimeMillis();
        this.updatedAt = System.currentTimeMillis();
        this.content = content;
        this.userId = userId;
        this.channelId = channelId;
    }

    public void update(String content) {
        this.content = content;
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
=======
    public long getCreatedAt() {
        return createdAt;
    }

    public long getUpdatedAt() {
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
        return updatedAt;
    }

    public String getContent() {
        return content;
    }

<<<<<<< HEAD
    public UUID getChannelId() {
        return channelId;
    }

    public UUID getAuthorId() {
        return authorId;
    }

    public void update(String newContent) {
        boolean anyValueUpdated = false;
        if (newContent != null && !newContent.equals(this.content)) {
            this.content = newContent;
            anyValueUpdated = true;
        }

        if (anyValueUpdated) {
            this.updatedAt = Instant.now().getEpochSecond();
        }
    }
=======
    public UUID getUserId() {
        return userId;
    }

    public UUID getChannelId() {
        return channelId;
    }
>>>>>>> d75c693196078007ca3026d275fcc99c030c9eb8
}
