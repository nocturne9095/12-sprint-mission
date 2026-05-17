package com.sprint.mission.discodeit.mapper;

import com.sprint.mission.discodeit.dto.response.PageResponse;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class PagingMapper {

  public <E, D> PageResponse<D> toPageResponse(Slice<E> slice, List<D> convertedContent) {
    return new PageResponse<>(
        convertedContent,
        slice.getNumber(),
        slice.getSize(),
        null
    );
  }
}