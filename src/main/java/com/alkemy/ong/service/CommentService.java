package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import com.alkemy.ong.exception.InsufficientPermissionsException;
import org.springframework.security.core.Authentication;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

public interface CommentService {
    void create(CommentRequest commentRequest);
    List<CommentResponse> getAllComments(String order);
    List<CommentResponse> getAllCommentsOfPost(UUID idPost);
    CommentResponse update(UUID id, CommentRequest commentRequest, Authentication authentication) throws InsufficientPermissionsException;

    CommentResponse delete(UUID id, Principal request);
}
