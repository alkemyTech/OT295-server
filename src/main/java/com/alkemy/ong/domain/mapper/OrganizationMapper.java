package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationBasicResponse;
import com.alkemy.ong.domain.response.OrganizationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrganizationMapper {

    public OrganizationBasicResponse entity2BasicDTOResponse(OrganizationEntity organizationEntity) {
        OrganizationBasicResponse response = new OrganizationBasicResponse();
        response.setName(organizationEntity.getName());
        response.setAddress(organizationEntity.getAddress());
        response.setImage(organizationEntity.getImage());
        response.setPhone(organizationEntity.getPhone());
        return response;
    }

    public OrganizationResponse entity2DTOResponse(OrganizationEntity organizationEntity) {
        OrganizationResponse response = new OrganizationResponse();
        response.setId(organizationEntity.getId());
        response.setName(organizationEntity.getName());
        response.setAddress(organizationEntity.getAddress());
        response.setImage(organizationEntity.getImage());
        response.setPhone(organizationEntity.getPhone());
        response.setEmail(organizationEntity.getEmail());
        response.setAboutUsText(organizationEntity.getAboutUsText());
        response.setWelcomeText(organizationEntity.getWelcomeText());
        response.setUrlInstagram(organizationEntity.getUrlInstagram());
        response.setUrlFacebook(organizationEntity.getUrlFacebook());
        response.setUrlLinkedin(organizationEntity.getUrlLinkedin());
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
        entity.setUrlInstagram(request.getUrlInstagram());
        entity.setUrlFacebook(request.getUrlFacebook());
        entity.setUrlLinkedin(request.getUrlLinkedin());
        return entity;
    }



}
