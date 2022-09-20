package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;

import java.util.UUID;

public interface OrganizationService {

    OrganizationBasicDTO getOrganization(UUID id);
    
    OrganizationResponse update(OrganizationRequest organizationRequest);
}
