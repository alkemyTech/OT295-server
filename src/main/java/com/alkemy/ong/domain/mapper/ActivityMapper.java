package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.ActivityEntity;
import com.alkemy.ong.domain.request.ActivityRequest;
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

    public ActivityEntity requestToEntity (ActivityRequest response){

        ActivityEntity activityEntity = new ActivityEntity();
        activityEntity.setName(response.getName());
        activityEntity.setContent(response.getContent());
        activityEntity.setImageUrl(response.getImageUrl());

        return  activityEntity;

    }

    public void activityRefreshValues(ActivityRequest activityRequest, ActivityEntity activityEntity) {

        activityEntity.setName(activityRequest.getName());
        activityEntity.setContent(activityRequest.getContent());
        activityEntity.setImageUrl(activityRequest.getImageUrl());
    }
}
