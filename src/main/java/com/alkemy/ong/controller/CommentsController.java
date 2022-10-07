package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CommentRequest commentRequest)
            throws NotFoundException {
        commentService.create(commentRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAll(@RequestParam(required = false, defaultValue = "ASC") String order) {
        List<CommentResponse> comments = commentService.getAllComments(order);
        return ResponseEntity.ok().body(comments);
    }

}

