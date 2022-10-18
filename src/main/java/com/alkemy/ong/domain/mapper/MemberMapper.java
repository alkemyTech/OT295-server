package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;


@Component
public class MemberMapper {
    public void memberEntityRefreshValues(MemberEntity entity, MemberRequest dto) {
        entity.setName(dto.getName());
        entity.setFacebookUrl(dto.getFacebookUrl());
        entity.setInstagramUrl(dto.getInstagramUrl());
        entity.setImage(dto.getImage());
        entity.setDescription(dto.getDescription());
    }

    public MemberResponse memberEntity2DTO(MemberEntity entity) {
        MemberResponse dto = new MemberResponse();
        dto.setName(entity.getName());
        dto.setInstagramUrl(entity.getInstagramUrl());
        dto.setInstagramUrl(entity.getInstagramUrl());
        dto.setImage(entity.getImage());
        dto.setDescription(entity.getDescription());
        return dto;
    }

    public MemberEntity mapToEntity(MemberRequest request) {
        MemberEntity entity = new MemberEntity();
        entity.setName(request.getName());
        entity.setImage(request.getImage());
        entity.setFacebookUrl(request.getFacebookUrl());
        entity.setInstagramUrl(request.getInstagramUrl());
        entity.setLinkedinUrl(request.getLinkedinUrl());
        entity.setDescription(request.getDescription());
        return entity;
    }

    public MemberResponse mapToResponse(MemberEntity entity) {
        MemberResponse response = new MemberResponse();
        response.setName(entity.getName());
        response.setImage(entity.getImage());
        response.setFacebookUrl(entity.getFacebookUrl());
        response.setInstagramUrl(entity.getInstagramUrl());
        response.setLinkedinUrl(entity.getLinkedinUrl());
        response.setDescription(entity.getDescription());
        return response;
    }

    public List<MemberResponse> memberEntityTOResponse(List<MemberEntity> entities) {

        List<MemberResponse> result = new ArrayList<>();

        for (MemberEntity e : entities)
            result.add(mapToResponse(e));

        return result;
    }
}

