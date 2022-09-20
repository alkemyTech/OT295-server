package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.ActivitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ActivitiesRepository extends JpaRepository<ActivitiesEntity, UUID> {

}
