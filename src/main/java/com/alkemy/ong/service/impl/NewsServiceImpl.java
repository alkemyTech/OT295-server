package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.mapper.NewsMapper;
import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.exception.ExternalServiceException;
import com.alkemy.ong.exception.NotFoundException;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;


@Service
public class NewsServiceImpl implements NewsService {

    private NewsMapper newsMapper;
    private NewsRepository newsRepository;

    @Autowired
    public NewsServiceImpl(NewsMapper newsMapper, NewsRepository newsRepository) {
        this.newsMapper = newsMapper;
        this.newsRepository = newsRepository;
    }

    @Override
    public NewsResponse save(NewsRequest newsRequest) {
        NewsEntity entity = new NewsEntity();
        entity.setName(newsRequest.getName());
        entity.setContent(newsRequest.getContent());
        entity.setImageUrl(newsRequest.getImageUrl());
        entity = this.newsRepository.save(entity);
        NewsResponse response = newsMapper.entityToResponse(entity);
        return response;
    }

    @Override
    public NewsResponse update(UUID id, NewsRequest newsRequest)  {
        NewsEntity entity=newsRepository.findById(id).get();
        entity.setName(newsRequest.getName());
        entity.setContent(newsRequest.getContent());
        entity.setImageUrl(newsRequest.getImageUrl());
        return newsMapper.entityToResponse(entity);
    }

    @Override
    public void delete(UUID id) {
        Optional<NewsEntity> entity= newsRepository.findById(id);
            if(!entity.isPresent()){
                throw new ParamNotFound("Id not valid");
            }
            newsRepository.delete(entity.get());


    }

}
