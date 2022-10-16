package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationMapper {

    public OrganizationResponse entity2DTOResponse(OrganizationEntity organizationEntity) {
        OrganizationResponse response = new OrganizationResponse();
        response.setName(organizationEntity.getName());
        response.setAddress(organizationEntity.getAddress());
        response.setImage(organizationEntity.getImage());
        response.setPhone(organizationEntity.getPhone());
        return response;
    }

    public OrganizationEntity DTO2Entity(OrganizationRequest request){
        OrganizationEntity entity = new OrganizationEntity();
        entity.setName(request.getName());
        entity.setAddress(request.getAddress());
        entity.setImage(request.getImage());
        entity.setPhone(request.getPhone());
        entity.setAboutUsText(request.getAboutUsText());
        entity.setEmail(request.getEmail());
        entity.setWelcomeText(request.getWelcomeText());
        entity.setURLInstagram(request.getURLInstagram());
        entity.setURLFacebook(request.getURLFacebook());
        entity.setURLLinkedin(request.getURLLinkedin());
        return entity;
    }



}
