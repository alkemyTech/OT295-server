package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
}

