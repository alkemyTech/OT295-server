package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.CommentEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class CommentMapper {

    public CommentEntity map(CommentRequest commentRequest, UserEntity user, NewsEntity news) {
        CommentEntity comment = new CommentEntity();
        comment.setBody(commentRequest.getBody());
        comment.setNews(news);
        comment.setUser(user);
        return comment;
    }

    public List<CommentResponse> entityToResponseList (List<CommentEntity> entity){

        List<CommentResponse> ret= new ArrayList<CommentResponse>();

        for(CommentEntity e : entity)
         ret.add(entityToResponse(e));

        return ret;

    }

    public CommentResponse entityToResponse(CommentEntity e) {

        CommentResponse ret = new CommentResponse();

        ret.setBody(e.getBody());

        return ret;
    }
}
