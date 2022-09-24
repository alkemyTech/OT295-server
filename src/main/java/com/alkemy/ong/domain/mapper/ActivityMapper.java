package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.ActivityEntity;
import com.alkemy.ong.domain.response.ActivityResponse;
import org.springframework.stereotype.Component;

@Component
public class ActivityMapper {

    public ActivityResponse entityToResponse(ActivityEntity entity) {
        ActivityResponse activityResponse = new ActivityResponse();
        activityResponse.setName(entity.getName());
        activityResponse.setContent(entity.getContent());
        activityResponse.setImageUrl(entity.getImageUrl());

        return activityResponse;
    }
}
