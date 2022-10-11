package com.alkemy.ong.service.impl;

import com.alkemy.ong.auth.security.RoleType;
import com.alkemy.ong.domain.entity.CommentEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.mapper.CommentMapper;
import com.alkemy.ong.domain.mapper.NewsMapper;
import com.alkemy.ong.domain.request.CommentRequest;
import com.alkemy.ong.domain.response.CommentResponse;
import com.alkemy.ong.exception.InsufficientPermissionsException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.repository.Specifications.CommentsSpecifications;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
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

    @Override
    public CommentResponse update(UUID id, CommentRequest commentRequest, Authentication authentication) throws InsufficientPermissionsException {
        CommentEntity comment = findBy(id);
        NewsEntity news = getNews(commentRequest.getNewsId());
        UserEntity user = getUser(commentRequest.getUserId());
        checkUser(comment, authentication);
        updateValues(comment, commentRequest, news, user);
        commentRepository.save(comment);
        return commentMapper.entityToResponse(comment);
    }

    private CommentEntity findBy(UUID id) {
        Optional<CommentEntity> result = commentRepository.findById(id);
        if (result.isEmpty()) {
            throw new NotFoundException("Comment not found");
        }
        return result.get();
    }

    private UserEntity getUser(UUID id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new NotFoundException("User not found.");
        }
        return user.get();
    }

    private NewsEntity getNews(UUID id) {
        Optional<NewsEntity> news = newsRepository.findById(id);
        if (news.isEmpty()) {
            throw new NotFoundException("Post not found.");
        }
        return news.get();
    }

    private void updateValues(CommentEntity comment, CommentRequest updateCommentRequest, NewsEntity news,
                              UserEntity user) {
        comment.setBody(updateCommentRequest.getBody());
        comment.setNews(news);
        comment.setUser(user);
        comment.setTimestamp(Timestamp.from(Instant.now()));
    }

    private void checkUser(CommentEntity comment, Authentication authentication)
            throws InsufficientPermissionsException {
        if (!isAdmin(authentication) && isNotCreator(comment, authentication)) {
            throw new InsufficientPermissionsException("Unauthorized to do changes");
        }
    }

    private boolean isAdmin(Authentication authentication) {
        return authentication.getAuthorities().stream()
                .anyMatch(r -> RoleType.ADMIN.getFullRoleName().equals(r.getAuthority()));
    }

    private boolean isNotCreator(CommentEntity comment, Authentication authentication) {
        return authentication.getName() != null
                && !authentication.getName().equals(comment.getUser().getEmail());
    }

}
