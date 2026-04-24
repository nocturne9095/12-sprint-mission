package com.sprint.mission.discodeit.controller;


import com.sprint.mission.discodeit.entity.BinaryContent;
import com.sprint.mission.discodeit.service.BinaryContentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/binaries")
@RequiredArgsConstructor
public class BinaryController {

    private final BinaryContentService binaryContentService;

    //단건 조회
   @GetMapping("/{binaryId}")
   public BinaryContent find(@PathVariable UUID binaryId) {
       return binaryContentService.find(binaryId);
   }

   //다건 조회
    @GetMapping
    public List<BinaryContent> findAllByIdIn(@RequestParam(name = "ids") List<UUID> binaryIds) {
        return binaryContentService.findAllByIdIn(binaryIds);
    }
}