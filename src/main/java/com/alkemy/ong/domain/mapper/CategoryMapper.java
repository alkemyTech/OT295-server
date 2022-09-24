package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.entity.OrganizationEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoryMapper {
//    @Mappings({
//            @Mapping(source = "name", target = "name")
//    })
//    CategoryBasicDTO toCategoryBasicDTO(CategoryEntity categoryEntity);
//
//    List<CategoryBasicDTO> toCategoryBasicDTOList(List<CategoryEntity> categories);
//
//    @InheritInverseConfiguration
//    CategoryEntity toCategoryEntity(CategoryBasicDTO categoryBasicDTO);
    public List<CategoryBasicDTO> categoryEntity2DTOList(List<CategoryEntity> entities){
        List<CategoryBasicDTO> dtos = new ArrayList<>();
        for(CategoryEntity entity : entities) {
        dtos.add(this.categoryEntity2DTO(entity));
    }
    return dtos;

}
    public CategoryBasicDTO categoryEntity2DTO(CategoryEntity entity){
        CategoryBasicDTO dto = new CategoryBasicDTO();
        dto.setName((entity.getName()));
        return dto;
    }


}
