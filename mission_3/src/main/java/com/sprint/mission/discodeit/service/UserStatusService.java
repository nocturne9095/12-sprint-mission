package com.sprint.mission.discodeit.service;

import com.sprint.mission.discodeit.dto.UserStatusRequest;
import com.sprint.mission.discodeit.dto.UserStatusResponse;
import com.sprint.mission.discodeit.dto.UserStatusUpdateRequest;
import com.sprint.mission.discodeit.repository.UserStatusRepository;

import java.util.List;
import java.util.UUID;

public interface UserStatusService {
    UserStatusResponse create(UserStatusRequest request);
    UserStatusResponse find(UUID id);
    List<UserStatusResponse> findAll();
    UserStatusResponse update(UserStatusUpdateRequest request);
    UserStatusResponse updateByUserId(UUID userId, UserStatusUpdateRequest request);
    void delete(UUID id);
}
