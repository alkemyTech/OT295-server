package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.response.NewsResponse;
import org.springframework.stereotype.Component;

@Component
public class NewsMapper {


    public NewsResponse entityToResponse(NewsEntity entity) {
        NewsResponse response = new NewsResponse();
        response.setName(entity.getName());
        response.setContent(entity.getContent());
        response.setImageUrl(entity.getImageUrl());

        return response;
    }

}
