package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.CategoryDTO;
import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.entity.OrganizationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class CategoryMapper {

    public List<CategoryBasicDTO> categoryEntity2DTOList(List<CategoryEntity> entities){
        List<CategoryBasicDTO> dtos = new ArrayList<>();
        for(CategoryEntity entity : entities) {
        dtos.add(this.categoryEntity2BasicDTO(entity));
    }
    return dtos;

}
    public CategoryBasicDTO categoryEntity2BasicDTO(CategoryEntity entity){
        CategoryBasicDTO dto = new CategoryBasicDTO();
        dto.setName((entity.getName()));
        return dto;
    }


    public CategoryDTO categoryEntity2DTO(CategoryEntity entity) {
        CategoryDTO dto = new CategoryDTO();
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setImage(entity.getImage());
        dto.setCreateTimestamp(entity.getCreateTimestamp());
        return dto;
    }

    public CategoryEntity categoryDTO2Entity(CategoryDTO dto) {
        CategoryEntity entity = new CategoryEntity();
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage());
        entity.setCreateTimestamp(dto.getCreateTimestamp());
        return entity;
    }

    public void categoryEntityRefreshValues(CategoryEntity entity, CategoryDTO dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setImage(dto.getImage(

        ));
    }

}
