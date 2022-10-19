package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewDTOResponse;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.domain.response.NewsResponsePage;
import com.alkemy.ong.service.NewsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Tag(name = "/news", description = "Operations with news")
@RestController
@RequestMapping("/news")
public class NewsController {

    private NewsService service;

    @Autowired
    public NewsController(NewsService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    @Operation(summary = "create a news", description = "create a news indicating content name and url image")
    @Parameter(name = "name", description = "enter the name of the novelty", required = true, example = "Bienvenido a SOMOS MAS")
    @Parameter(name = "content", description = "enter the news content", required = true, example = "SOMOS MAS se encarga de generar procesos de crecimientos hacia las personas")
    @Parameter(name = "imageUrl", description = "enter novelty image url", required = true, example = "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png")
    public ResponseEntity<NewsResponse> create(@Valid @RequestBody NewsRequest newsRequest) {
        NewsResponse news = service.save(newsRequest);

        return ResponseEntity.ok().body(news);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "update a news", description = "update a news item obtained by id by editing its name content and image url fields")
    @Parameter(name = "id", description = "enter the id of the news to update", required = true, example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    @Parameter(name = "name", description = "enter the name of the novelty", required = true, example = "Bienvenido a SOMOS MAS")
    @Parameter(name = "content", description = "enter the news content", required = true, example = "SOMOS MAS se encarga de generar procesos de crecimientos hacia las personas")
    @Parameter(name = "imageUrl", description = "enter novelty image url", required = true, example = "www.paginaWeb.com/1234")
    public ResponseEntity<NewsResponse> update(@PathVariable UUID id, @Valid @RequestBody NewsRequest newsRequest) {
        NewsResponse response = service.update(id, newsRequest);
        return ResponseEntity.ok().body(response);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "delete a news", description = "delete a news by id")
    @Parameter(name = "id", description = "enter the id of the news to delete", required = true, example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/{id}")
    @Operation(summary = "get a news", description = "get news by id")
    public ResponseEntity<NewDTOResponse> getNewById(@PathVariable UUID id) {
        NewDTOResponse result = service.getNewById(id);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    @Operation(summary = "get a news by page", description = "get a news by page ")
    @Parameter(name = "page", description = "enter the page of the news to get", required = true, example = "1")
    public ResponseEntity<NewsResponsePage> getAll(@PathVariable Integer page) {
        NewsResponsePage news = service.getAllNews(page);
        return ResponseEntity.ok().body(news);
    }
}

