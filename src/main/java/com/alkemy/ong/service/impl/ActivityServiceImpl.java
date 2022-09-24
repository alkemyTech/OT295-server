package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.ActivityEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.mapper.ActivityMapper;
import com.alkemy.ong.domain.request.ActivityRequest;
import com.alkemy.ong.domain.response.ActivityResponse;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.repository.ActivityRepository;
import com.alkemy.ong.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    ActivityRepository activityRepository;

    @Autowired
    ActivityMapper activityMapper;

    @Override
    public ActivityResponse save(ActivityRequest activity) {

        ActivityEntity entity = new ActivityEntity();
        entity.setName(activity.getName());
        entity.setContent(activity.getContent());
        entity.setImageUrl(activity.getImageUrl());

        entity= this.activityRepository.save(entity);

        ActivityResponse response = activityMapper.entityToResponse(entity);

        return  response;
    }
}
