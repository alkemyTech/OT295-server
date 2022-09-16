package com.alkemy.ong.repository;

import com.alkemy.ong.domain.ActivitiesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivitiesRepository extends JpaRepository<ActivitiesEntity,Long> {
    @Modifying
    @Query("UPDATE ActivitiesEntity a SET a.softDeleted = true WHERE a.activitiesId = :id")
    void softDelete(@Param("id") Long id);

}
