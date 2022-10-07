package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;

import java.util.List;

public interface CommentService {
    void create(CommentRequest commentRequest);
    List<CommentResponse> getAllComments(String order);
}
