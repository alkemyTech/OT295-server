package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.TestimonialEntity;
import com.alkemy.ong.domain.mapper.TestimonialMapper;
import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.TestimonialResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TestimonialServiceImpl implements TestimonialService {

    private final TestimonialMapper testimonialMapper;

    private final TestimonialRepository testimonialRepository;

    @Override
    public TestimonialResponse saveTestimonial(TestimonialRequest testimonialRequest) {
        TestimonialEntity entity = testimonialMapper.DTO2Entity(testimonialRequest);
        entity.setName(testimonialRequest.getName());
        entity.setImage(testimonialRequest.getImage());
        entity.setContent(testimonialRequest.getContent());
        entity.setCreateTimestamp(testimonialRequest.getCreateTimestamp());
        return testimonialMapper.entity2DTOResponse(testimonialRepository.save(entity));
    }

    public TestimonialResponse update(TestimonialRequest testimonialRequest, UUID id){
        TestimonialEntity entity = getById(id);
        entity.setName(testimonialRequest.getName());
        entity.setImage(testimonialRequest.getImage());
        entity.setContent(testimonialRequest.getContent());
        return testimonialMapper.entity2DTOResponse(testimonialRepository.save(entity));
    }

    public void delete(UUID id){
        testimonialRepository.delete(getById(id));
    }
    public TestimonialEntity getById(UUID id){
        return testimonialRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Testimonial not found"));
    }
}
