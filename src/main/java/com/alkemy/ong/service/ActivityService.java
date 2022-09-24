package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.ActivityRequest;
import com.alkemy.ong.domain.response.ActivityResponse;

public interface ActivityService {

    ActivityResponse save (ActivityRequest activity);
}
