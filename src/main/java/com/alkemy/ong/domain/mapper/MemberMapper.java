package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.CategoryDTO;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.dto.MemberDTO;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;

@Component
public class MemberMapper {
    public void memberEntityRefreshValues(MemberEntity entity, MemberDTO dto) {
        entity.setName(dto.getName());
        entity.setFacebookUrl(dto.getFacebookUrl());
        entity.setInstagramUrl(dto.getInstagramUrl());
        entity.setImage(dto.getImage());
        entity.setDescription(dto.getDescription());
    }
    public MemberDTO memberEntity2DTO(MemberEntity entity) {
        MemberDTO dto = new MemberDTO();
        dto.setName(entity.getName());
        dto.setInstagramUrl(entity.getInstagramUrl());
        dto.setInstagramUrl(entity.getInstagramUrl());
        dto.setImage(entity.getImage());
        dto.setDescription(entity.getDescription());
        return dto;
    }
}

