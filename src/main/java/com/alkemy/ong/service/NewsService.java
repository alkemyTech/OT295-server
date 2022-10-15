package com.alkemy.ong.service;

import com.alkemy.ong.domain.response.NewDTOResponse;
import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewsResponsePage;
import com.alkemy.ong.domain.response.NewsResponse;
import java.util.UUID;

public interface NewsService {
    NewsResponse save(NewsRequest newsRequest);

    NewsResponse update(UUID id, NewsRequest newsRequest);

    void delete(UUID id);

    NewDTOResponse getNewById(UUID id);

    NewsResponsePage getAllNews(Integer page);
}
