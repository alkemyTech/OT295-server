package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.SlideEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SlideRepository extends JpaRepository<SlideEntity, UUID> {

    @Query(value = "SELECT MAX(slide_order) FROM slides WHERE organization_id LIKE :organizationId", nativeQuery = true)
    Integer findMaxSlideOrder(@Param("organizationId") UUID organizationId);

}
