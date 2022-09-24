package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.ActivityRequest;
import com.alkemy.ong.domain.response.ActivityResponse;

import java.util.UUID;

public interface ActivityService {

    ActivityResponse save (ActivityRequest activity);

    ActivityResponse update(UUID id, ActivityRequest activityRequest);
}
