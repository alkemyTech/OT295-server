package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;

import java.util.List;

public interface OrganizationService {

    List<OrganizationBasicDTO> getOrganizations();

    OrganizationResponse update(OrganizationRequest organizationRequest);
}
