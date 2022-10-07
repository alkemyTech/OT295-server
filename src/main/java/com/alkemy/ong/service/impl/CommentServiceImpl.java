package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.CommentEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.mapper.CommentMapper;
import com.alkemy.ong.domain.mapper.NewsMapper;
import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.repository.Specifications.CommentsSpecifications;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentMapper commentMapper;
    private CommentRepository commentRepository;
    private UserRepository userRepository;
    private NewsRepository newsRepository;
    private CommentsSpecifications commentsSpecifications;
    private NewsMapper newsMapper;


    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper, CommentRepository commentRepository, UserRepository userRepository, NewsRepository newsRepository, CommentsSpecifications commentsSpecifications) {
        this.commentMapper = commentMapper;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.newsRepository = newsRepository;
        this.commentsSpecifications = commentsSpecifications;
    }

    @Override
    public void create(CommentRequest commentRequest) {
        UserEntity user = getUser(commentRequest.getUserId());
        NewsEntity news = getNews(commentRequest.getNewsId());
        commentRepository.save(commentMapper.map(commentRequest,user,news));
    }

    @Override
    public List<CommentResponse> getAllComments(String order) {
        CommentRequest comment = new  CommentRequest(order);
        List<CommentEntity> entities = commentRepository.findAll(this.commentsSpecifications.getByDate(comment));
        List<CommentResponse> ret = commentMapper.entityToResponseList(entities);
        return ret;
    }

    @Override
    public List<CommentResponse> getAllCommentsOfPost(UUID idPost) {
        NewsEntity newEntity = newsRepository.getById(idPost);
        List<CommentEntity> commentEntity = newEntity.getCommentList();
        List<CommentResponse> ret = commentMapper.entityToResponseList(commentEntity);

        return ret;
    }

    private UserEntity getUser(UUID id) {
        UserEntity user = userRepository.findById(id).get();
        if (user == null) {
            throw new NotFoundException("User not found.");
        }
        return user;
    }

    private NewsEntity getNews(UUID id) {
        NewsEntity news = newsRepository.findById(id).get();
        if (news == null) {
            throw new NotFoundException("Post not found.");
        }
        return news;
    }
}
