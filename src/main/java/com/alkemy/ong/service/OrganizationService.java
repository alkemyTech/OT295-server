package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;

public interface OrganizationService {
    OrganizationBasicDTO getOrganization(Long id);

    OrganizationResponse update(OrganizationRequest organizationRequest);
}
