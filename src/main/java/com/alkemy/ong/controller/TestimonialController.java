package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.TestimonialPageResponse;
import com.alkemy.ong.domain.response.TestimonialResponse;
import com.alkemy.ong.service.TestimonialService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/testimonials")
@RequiredArgsConstructor
public class TestimonialController {

    private final TestimonialService testimonialService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<TestimonialResponse> createTestimonial(@Valid @RequestBody TestimonialRequest request){
        return ResponseEntity.ok().body(testimonialService.saveTestimonial(request));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<TestimonialResponse> updateTestimonial(@Valid @RequestBody TestimonialRequest request, @PathVariable UUID id){
        TestimonialResponse response = testimonialService.update(request, id);
        return ResponseEntity.ok().body(response);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteTestimonial(@PathVariable UUID id){
        this.testimonialService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    public ResponseEntity<TestimonialPageResponse> getAll(@PathVariable Integer page){
        TestimonialPageResponse testimonial = testimonialService.getAllTestimonials(page);
        return ResponseEntity.ok().body(testimonial);
    }

}
