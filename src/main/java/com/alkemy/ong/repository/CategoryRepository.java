//------------------------------------------------------------------------------//
//  CategoryRepository as base repository for future implementation
//
//  By                          DATE                TICKET              DETAILS/CHANGES
//  Daniel-Zemanate             2022-09-16          OT295-19            creation of base repsitory, extends JPA
//------------------------------------------------------------------------------//


package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {
}
