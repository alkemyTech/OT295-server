package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.response.CategoryBasicResponse;
import com.alkemy.ong.domain.response.CategoryResponse;
import com.alkemy.ong.domain.response.CategoryResponsePage;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.mapper.CategoryMapper;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<CategoryBasicResponse> getAllCategories() {
        List<CategoryEntity> entities = categoryRepository.findAll();
        List<CategoryBasicResponse> result = categoryMapper.categoryEntity2DTOList(entities);
        return result;
    }

    public CategoryResponsePage getAllCategories(Integer page) {
        CategoryResponsePage respuesta = new CategoryResponsePage();
        Pageable pageable = PageRequest.of(page, 10);
        Page<CategoryEntity> categoryPage = categoryRepository.findAll(pageable);
        int totalElements = (int) categoryPage.getTotalElements();
        Page<CategoryResponse> respuestaFinal = new PageImpl<CategoryResponse>(categoryPage.getContent()
                .stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getDescription(),
                        category.getImage(),
                        category.getCreateTimestamp()))
                .collect(Collectors.toList()), pageable, totalElements);
        respuesta.setRespuesta(respuestaFinal);

        if((pageable.getPageNumber()+1)>0 && (pageable.getPageNumber()+1)<respuestaFinal.getTotalPages()){
            respuesta.setPreviousPage("localhost:8080/categories/page/" + (pageable.getPageNumber() - 1));
            respuesta.setNextPage("localhost:8080/categories/page/" + (pageable.getPageNumber() + 1));}
        if((pageable.getPageNumber()+1)==respuestaFinal.getTotalPages()){
            respuesta.setPreviousPage("localhost:8080/categories/page/" + (pageable.getPageNumber() - 1));
            respuesta.setNextPage("nonexistent next page");}
        if(pageable.getPageNumber()==0){
            respuesta.setPreviousPage("nonexistent previous page");
            respuesta.setNextPage("localhost:8080/categories/page/" + (pageable.getPageNumber() + 1));}

        return respuesta;
    }

            @Override
    public CategoryResponse getDetailsById(UUID id) {
        Optional<CategoryEntity> entity = this.categoryRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id not valid");
        }
        CategoryResponse categoryResponse = this.categoryMapper.categoryEntity2DTO(entity.get());
        return categoryResponse;
    }

    @Override
    public CategoryResponse save(CategoryResponse dto) {
        CategoryEntity entity = categoryMapper.categoryDTO2Entity(dto);
        CategoryEntity entitySaved = categoryRepository.save(entity);
        CategoryResponse result = categoryMapper.categoryEntity2DTO(entitySaved);
        return result;
    }

    @Override
    public void delete(UUID id) {
        Optional<CategoryEntity> entity = this.categoryRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id not valid");
        }
        this.categoryRepository.delete(entity.get());
    }

    @Override
    public CategoryResponse update(UUID id, CategoryResponse category) {
        Optional<CategoryEntity> entity = this.categoryRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id not valid");
        }
        this.categoryMapper.categoryEntityRefreshValues(entity.get(), category);
        CategoryEntity entitySaved = this.categoryRepository.save(entity.get());
        CategoryResponse result = this.categoryMapper.categoryEntity2DTO(entitySaved);

        return result;
    }

}
