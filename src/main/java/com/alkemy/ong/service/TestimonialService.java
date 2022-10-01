package com.alkemy.ong.service;


import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.TestimonialResponse;

import java.util.UUID;

public interface TestimonialService {

    TestimonialResponse saveTestimonial(TestimonialRequest testimonialRequest);

    void delete(UUID id);

    TestimonialResponse update(TestimonialRequest testimonialRequest, UUID id);

}
