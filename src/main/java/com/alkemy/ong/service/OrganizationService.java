package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;

import java.util.UUID;

public interface OrganizationService {
    OrganizationBasicDTO getOrganization(UUID id);
}
