package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.mapper.CategoryMapper;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<CategoryBasicDTO> getAllCategories() {
        List<CategoryEntity> entities = categoryRepository.findAll();
        List<CategoryBasicDTO> result = categoryMapper.categoryEntity2DTOList(entities);
        return result;
    }
}
