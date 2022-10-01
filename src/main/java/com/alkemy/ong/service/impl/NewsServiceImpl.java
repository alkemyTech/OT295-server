package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.mapper.NewsMapper;
import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewDTOResponse;
import com.alkemy.ong.domain.response.NewsResponse;
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
    public NewsResponse update(UUID id, NewsRequest newsRequest) {
        Optional<NewsEntity> entity = newsRepository.findById(id);
        if (entity.isEmpty()) {
            throw new NotFoundException("News not exist");
        }
        NewsEntity news = entity.get();
        news.setName(newsRequest.getName());
        news.setContent(newsRequest.getContent());
        news.setImageUrl(newsRequest.getImageUrl());
        return newsMapper.entityToResponse(news);
    }

    @Override
    public void delete(UUID id) {

        if (!newsRepository.existsById(id)) {
            throw new NotFoundException("News not exist");
        }
        newsRepository.delete(newsRepository.findById(id).get());


    }

    public NewDTOResponse getNewById(UUID id) {
        NewsEntity newsEntity = getNew(id);
        NewDTOResponse dto = newsMapper.toNewDtoResponse(newsEntity);
        return dto;
    }

    private NewsEntity getNew(UUID newId) {
        return newsRepository.findById(newId).orElseThrow(
                () -> new ParamNotFound("New not found: " + newId));
    }

}
