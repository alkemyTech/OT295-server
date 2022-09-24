package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.NewsRequest;
import com.alkemy.ong.domain.response.NewsResponse;


public interface NewsService {
    NewsResponse save(NewsRequest newsRequest);
}
