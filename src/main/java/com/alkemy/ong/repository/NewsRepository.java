package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Long> {
    @Modifying
    @Query("Update NewsEntity n SET n.softDeleted = true WHERE n.newsId = :id")
    void softDelete(@Param("id") Long id);
}
