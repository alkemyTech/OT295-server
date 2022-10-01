package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;
import org.springframework.stereotype.Component;



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

    public MemberEntity map(MemberRequest request){
        MemberEntity entity= new MemberEntity();
        entity.setName(request.getName());
        entity.setFacebookUrl(request.getFacebookUrl());
        entity.setInstagramUrl(request.getInstagramUrl());
        entity.setLinkedinUrl(request.getLinkedinUrl());
        entity.setDescription(request.getDescription());
        return entity;
    }
    public MemberResponse map(MemberEntity entity){
        MemberResponse response= new MemberResponse();
        response.setName(entity.getName());
        response.setFacebookUrl(entity.getFacebookUrl());
        response.setInstagramUrl(entity.getInstagramUrl());
        response.setLinkedinUrl(entity.getLinkedinUrl());
        response.setDescription(entity.getDescription());
        return response;
    }
}

