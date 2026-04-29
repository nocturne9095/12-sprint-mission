package com.sprint.mission.discodeit.controller;

import com.sprint.mission.discodeit.dto.request.BinaryContentCreateRequest;
import com.sprint.mission.discodeit.dto.request.MessageCreateRequest;
import com.sprint.mission.discodeit.dto.request.MessageUpdateRequest;
import com.sprint.mission.discodeit.entity.Message;
import com.sprint.mission.discodeit.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    //메시지 보내기(파일 포함)
    @RequestMapping(method = RequestMethod.POST)
    public Message create(@RequestBody MessageAndBinaryRequest combineRequest) {
        return messageService.create(
                combineRequest.messageRequest(), combineRequest.binaryRequests() != null ?
                combineRequest.binaryRequests() : new ArrayList<>()
        );
    }

    //메시지 수정
    @RequestMapping(value = "/{messageId}", method = RequestMethod.PATCH)
    public Message update(@PathVariable UUID messageId, @RequestBody MessageUpdateRequest request) {
        return messageService.update(messageId, request);
    }

    //메시지 삭제
    @RequestMapping(value = "/{messageId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable UUID messageId) {
        messageService.delete(messageId);
    }

    //특정 채널 메시지 목록 조회
    @RequestMapping(method = RequestMethod.GET)
    public List<Message> findAllByChannelId(@RequestParam UUID channelId) {
        return messageService.findAllByChannelId(channelId);
    }


    //메시지 & 파일 DTO
    public record MessageAndBinaryRequest(
            MessageCreateRequest messageRequest,
            List<BinaryContentCreateRequest> binaryRequests
    ) {}


}
