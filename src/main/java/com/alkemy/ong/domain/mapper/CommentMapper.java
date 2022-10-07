package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.CommentEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.request.CommentRequest;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public CommentEntity map(CommentRequest commentRequest, UserEntity user, NewsEntity news) {
        CommentEntity comment = new CommentEntity();
        comment.setBody(commentRequest.getBody());
        comment.setNews(news);
        comment.setUser(user);
        return comment;
    }
}
