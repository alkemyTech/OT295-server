package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.response.NewDTOResponse;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.response.NewsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NewsMapper {

    @Lazy
    private final CategoryMapper categoryMapper;

    public NewsResponse entityToResponse(NewsEntity entity) {
        NewsResponse response = new NewsResponse();
        response.setName(entity.getName());
        response.setContent(entity.getContent());
        response.setImageUrl(entity.getImageUrl());

        return response;
    }

    public NewDTOResponse toNewDtoResponse(NewsEntity entity){
        NewDTOResponse dto = new NewDTOResponse();
        dto.setName(entity.getName());
        dto.setContent(entity.getContent());
        dto.setImageUrl(entity.getImageUrl());
        dto.setTimestamp(entity.getCreateTimestamp());
        dto.setCategory(categoryMapper.categoryEntity2DTO(entity.getCategory()));
        return dto;
    }

}
