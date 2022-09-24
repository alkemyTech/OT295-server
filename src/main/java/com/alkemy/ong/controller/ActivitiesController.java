package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.ActivityRequest;
import com.alkemy.ong.domain.response.ActivityResponse;
import com.alkemy.ong.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/activities")
public class ActivitiesController {

    @Autowired
    ActivityService activitiesService;

    @PostMapping
    public ResponseEntity<ActivityResponse> save(@Valid @RequestBody ActivityRequest activityRequest) {
        ActivityResponse activitySaved = activitiesService.save(activityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(activitySaved);

    }
}
