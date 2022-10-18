package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.request.CategoryRequest;
import com.alkemy.ong.domain.response.CategoryBasicResponse;
import com.alkemy.ong.domain.response.CategoryResponse;
import com.alkemy.ong.domain.entity.CategoryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {

    public List<CategoryBasicResponse> categoryEntity2DTOList(List<CategoryEntity> entities){
        List<CategoryBasicResponse> dtos = new ArrayList<>();
        for(CategoryEntity entity : entities) {
        dtos.add(this.categoryEntity2BasicDTO(entity));
    }
    return dtos;

}
    public CategoryBasicResponse categoryEntity2BasicDTO(CategoryEntity entity){
        CategoryBasicResponse dto = new CategoryBasicResponse();
        dto.setName((entity.getName()));
        return dto;
    }


    public CategoryResponse categoryEntity2DTO(CategoryEntity entity) {
        CategoryResponse dto = new CategoryResponse();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setCreateTimestamp(entity.getCreateTimestamp());
        return dto;
    }

    public CategoryEntity categoryDTO2Entity(CategoryRequest dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        return entity;
    }

    public void categoryEntityRefreshValues(CategoryEntity entity, CategoryRequest dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage(

        ));
    }

}
