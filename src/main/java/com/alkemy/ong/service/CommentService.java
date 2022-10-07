package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.CommentRequest;

public interface CommentService {
    void create(CommentRequest commentRequest);
}
