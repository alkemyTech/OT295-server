package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.ActivityRequest;
import com.alkemy.ong.domain.response.ActivityResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/activities")
public class ActivityController {

    @Autowired
    private ActivityService activitiesService;

    @PostMapping
    public ResponseEntity<ActivityResponse> save(@Valid @RequestBody ActivityRequest activityRequest) {
        ActivityResponse activitySaved = activitiesService.save(activityRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(activitySaved);

    }

    @PutMapping("/{id}")
    public ResponseEntity<ActivityResponse> update(@Valid @PathVariable UUID id, @RequestBody ActivityRequest activityRequest) throws NotFoundException {
        ActivityResponse response = activitiesService.update(id, activityRequest);
        return ResponseEntity.ok().body(response);
    }
}
