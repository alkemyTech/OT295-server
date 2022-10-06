package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.TestimonialEntity;
import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.TestimonialResponse;
import org.springframework.stereotype.Component;

@Component
public class TestimonialMapper {

    public TestimonialEntity DTO2Entity(TestimonialRequest testimonialRequest){
        TestimonialEntity entity = new TestimonialEntity();
        entity.setName(testimonialRequest.getName());
        entity.setImage(testimonialRequest.getImage());
        entity.setContent(testimonialRequest.getContent());
        return entity;
    }

    public TestimonialResponse entity2DTOResponse(TestimonialEntity entity){
        TestimonialResponse dto = new TestimonialResponse();
        dto.setName(entity.getName());
        dto.setContent(entity.getContent());
        return dto;
    }



}
