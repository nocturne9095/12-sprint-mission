package com.sprint.mission.discodeit.entity;

import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

@Getter
public class BinaryContent implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;
    private final Instant createdAt;
    private Instant updatedAt;
    private final String fileName;
    private final byte[] data;
    private UUID messageId;

    public BinaryContent(String fileName, byte[] data) {
        this.id = UUID.randomUUID();
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
        this.fileName = fileName;
        this.data = data;
    }

    //메세지랑 파일 연결할 때
    public void updateMessageId(UUID messageId) {
        this.messageId = messageId;
        this.updatedAt = Instant.now();
    }

}
