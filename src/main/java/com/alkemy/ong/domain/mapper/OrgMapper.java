package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.request.OrganizationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrgMapper {

    public OrganizationRequest entity2DTO(OrganizationEntity organizationEntity) {
        OrganizationRequest dto = new OrganizationRequest();
        dto.setName(organizationEntity.getName());
        dto.setAddress(organizationEntity.getAddress());
        dto.setImage(organizationEntity.getImage());
        dto.setPhone(organizationEntity.getPhone());
        return dto;
    }

}
