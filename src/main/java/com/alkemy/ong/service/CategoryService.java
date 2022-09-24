package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;

import java.util.List;

public interface CategoryService {
    List<CategoryBasicDTO> getAllCategories();
}
