package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.CategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryBasicDTO> getAllCategories();
    Page<CategoryDTO> getAllCategories(Pageable pageable);

    CategoryDTO getDetailsById(UUID id);

    CategoryDTO save(CategoryDTO category);

    void delete(UUID id);

    CategoryDTO update(UUID id, CategoryDTO category);
}
