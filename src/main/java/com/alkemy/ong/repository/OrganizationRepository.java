package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<OrganizationEntity,Long> {
}
