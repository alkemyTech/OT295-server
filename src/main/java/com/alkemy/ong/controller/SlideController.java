package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.service.SlideService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequestMapping("/slides")
@RequiredArgsConstructor
public class SlideController {

    private final SlideService slideService;

    @PostMapping
    public ResponseEntity<SlideResponse> saveSlid(@RequestBody SlideRequest request){
        return ResponseEntity.ok().body(slideService.saveSlide(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlideResponse> getById(@PathVariable UUID id){
        return ResponseEntity.status(HttpStatus.OK).body(slideService.getByIdResponse(id));
    }

}
