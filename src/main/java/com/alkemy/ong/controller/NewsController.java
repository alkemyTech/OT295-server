package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("news")
public class NewsController {

    private NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NewsResponse> create(@Valid @RequestBody NewsRequest newsRequest) {
        NewsResponse news = service.save(newsRequest);
        return ResponseEntity.ok().body(news);
    }
    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> update(@Valid @PathVariable UUID id, @RequestBody NewsRequest  newsRequest) {
        NewsResponse response = service.update(id,newsRequest);
        return ResponseEntity.ok().body(response);
    }
}

