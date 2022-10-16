package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.entity.TestimonialEntity;
import com.alkemy.ong.domain.mapper.TestimonialMapper;
import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.domain.response.TestimonialPageResponse;
import com.alkemy.ong.domain.response.TestimonialResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.repository.TestimonialRepository;
import com.alkemy.ong.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Collectors;

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
    @Override
    public TestimonialPageResponse getAllTestimonials(Integer page) {
        TestimonialPageResponse response=new TestimonialPageResponse();
        Pageable pageable= PageRequest.of(page, 10);
        Page<TestimonialEntity> testimonialPage=testimonialRepository.findAll(pageable);
        int totalElements=(int) testimonialPage.getTotalElements();
        Page<TestimonialResponse> responses=new PageImpl<TestimonialResponse>(testimonialPage.getContent()
                .stream()
                .map(testimonial->new TestimonialResponse(
                        testimonial.getName(),
                        testimonial.getContent()))
                .collect(Collectors.toList()),pageable,totalElements);
        response.setResponses(responses);
        if((pageable.getPageNumber()+1)>0 && (pageable.getPageNumber()+1)<responses.getTotalPages()){
            response.setPreviousPage("localhost:8080/testimonials/page/" + (pageable.getPageNumber() - 1));
            response.setNextPage("localhost:8080/testimonials/page/" + (pageable.getPageNumber() + 1));}
        if((pageable.getPageNumber()+1)==responses.getTotalPages()){
            response.setPreviousPage("localhost:8080/testimonials/page/" + (pageable.getPageNumber() - 1));
            response.setNextPage("nonexistent next page");}
        if(pageable.getPageNumber()==0){
            response.setPreviousPage("nonexistent previous page");
            response.setNextPage("localhost:8080/testimonials/page/" + (pageable.getPageNumber() + 1));}
        return response;
    }
}
