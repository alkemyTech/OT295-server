package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.TestimonialRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.TestimonialPageResponse;
import com.alkemy.ong.domain.response.TestimonialResponse;
import com.alkemy.ong.service.TestimonialService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
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
    @Operation(summary = "Create a testimonial through a TestimonialRequest", description = "This endpoint inserts a new testimonial")
    public ResponseEntity<TestimonialResponse> createTestimonial(@Parameter(description = "It is a body in JSON format with the entity's atributes")@Valid @RequestBody TestimonialRequest request){
        return ResponseEntity.ok().body(testimonialService.saveTestimonial(request));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "Update information about a testimonial", description = "This endpoint requires a testimonial ID and Body to perform update of information")
    @Parameter(name ="id", description = "UUID type for testimonial id", example="00000000-0000-0000-0000-000000000001")
    public ResponseEntity<TestimonialResponse> updateTestimonial(@Valid @RequestBody TestimonialRequest request, @PathVariable UUID id){
        TestimonialResponse response = testimonialService.update(request, id);
        return ResponseEntity.ok().body(response);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete information about a testimonial", description = "This endpoint requires a testimonial ID to perform delete of information")
    @Parameter(name ="id", description = "UUID type for testimonial id", example="00000000-0000-0000-0000-000000000001")
    public ResponseEntity<Object> deleteTestimonial(@PathVariable UUID id){
        this.testimonialService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    @Operation(summary = "Get a paginated list of testimonials with minimal information", description = "This endpoint retrieves a paginated list of testimonials containing minimal information")
    @Parameter(name ="page", description = "It is the page number to access", example="1")
    public ResponseEntity<TestimonialPageResponse> getAll(@PathVariable Integer page){
        TestimonialPageResponse testimonial = testimonialService.getAllTestimonials(page);
        return ResponseEntity.ok().body(testimonial);
    }

}
