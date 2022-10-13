package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.SlideDTOImageOrder;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/slides")
@RequiredArgsConstructor
public class SlideController {

    private final SlideService slideService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<SlideResponse> saveSlid(@RequestBody SlideRequest request){
        return ResponseEntity.ok().body(slideService.saveSlide(request));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<SlideResponse> getById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(slideService.getByIdResponse(id));
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping()
    public ResponseEntity<List<SlideDTOImageOrder>> readAllSlides(){
        return new ResponseEntity<>(slideService.readAllSlides(),HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<SlideResponse> update(@PathVariable UUID id, @Valid @RequestBody SlideRequest request) {
        SlideResponse response = slideService.update(id,request);
        return ResponseEntity.ok().body(response);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable UUID id){
        this.slideService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
