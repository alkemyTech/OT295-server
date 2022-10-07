package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;

import java.util.List;
import java.util.UUID;

public interface CommentService {
    void create(CommentRequest commentRequest);
    List<CommentResponse> getAllComments(String order);
    List<CommentResponse> getAllCommentsOfPost(UUID idPost);
}
