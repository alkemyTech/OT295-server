package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    public ResponseEntity<Void> create(@RequestBody @Valid CommentRequest commentRequest)
            throws NotFoundException {
       commentService.create(commentRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

