package com.alkemy.ong.service;

import com.alkemy.ong.domain.entity.SlideEntity;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;

import java.util.List;
import java.util.UUID;

public interface SlideService {

    SlideResponse saveSlide(SlideRequest request);

    SlideEntity getById(UUID id);

    SlideResponse getByIdResponse(UUID id);

    List<SlideResponse> readAllSlides();

    SlideResponse update(UUID id, SlideRequest request);

    void delete(UUID id);
}
