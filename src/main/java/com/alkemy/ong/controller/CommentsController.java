package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import com.alkemy.ong.exception.InsufficientPermissionsException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("comments")
public class CommentsController {
    @Autowired
    private CommentService commentService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CommentRequest commentRequest)
            throws NotFoundException {
        commentService.create(commentRequest);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<CommentResponse>> getAllOrder(@RequestParam(required = false, defaultValue = "ASC") String order) {
        List<CommentResponse> comments = commentService.getAllComments(order);
        return ResponseEntity.ok().body(comments);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/post/{id}")
    public ResponseEntity<List<CommentResponse>> getAll(@PathVariable UUID id) {
        List<CommentResponse> comments = commentService.getAllCommentsOfPost(id);
        return ResponseEntity.ok().body(comments);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<CommentResponse> update(@PathVariable UUID id,
                                                  @Valid @RequestBody CommentRequest commentRequest,Authentication authentication) throws InsufficientPermissionsException {
        CommentResponse commentResponse = commentService.update(id, commentRequest,authentication);
        return ResponseEntity.ok().body(commentResponse);
    }


    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<CommentResponse> delete(@PathVariable("id") UUID id, Principal request){
        CommentResponse response = commentService.delete(id, request);
        return new ResponseEntity<>(response,HttpStatus.ACCEPTED);
    }

}

