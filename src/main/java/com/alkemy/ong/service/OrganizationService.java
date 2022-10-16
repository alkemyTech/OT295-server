package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;

import java.util.List;
import java.util.UUID;

public interface OrganizationService {

    //List<OrganizationResponse> getOrganizations();

    OrganizationResponse update(OrganizationRequest organizationRequest);

    OrganizationEntity getById(UUID id);

    OrganizationResponse save(OrganizationRequest organizationRequest);

    OrganizationResponse getPublicInformation(UUID id);

    void delete(UUID id);
}
