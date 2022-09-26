package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewDTOResponse;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/news")
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
    public ResponseEntity<NewsResponse> update(@PathVariable UUID id,@Valid @RequestBody NewsRequest  newsRequest) {
        NewsResponse response = service.update(id,newsRequest);
        return ResponseEntity.ok().body(response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id){
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewDTOResponse> getNewById(@PathVariable UUID id){
        NewDTOResponse result = service.getNewById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}

