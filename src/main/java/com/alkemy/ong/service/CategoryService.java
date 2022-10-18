package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.CategoryRequest;
import com.alkemy.ong.domain.response.CategoryBasicResponse;
import com.alkemy.ong.domain.response.CategoryResponse;
import com.alkemy.ong.domain.response.CategoryResponsePage;

import java.util.List;
import java.util.UUID;

public interface CategoryService {

    List<CategoryBasicResponse> getAllCategories();

    CategoryResponsePage getAllCategories(Integer page);

    CategoryResponse getDetailsById(UUID id);

    CategoryResponse save(CategoryRequest category);

    void delete(UUID id);

    CategoryResponse update(UUID id, CategoryRequest category);
}