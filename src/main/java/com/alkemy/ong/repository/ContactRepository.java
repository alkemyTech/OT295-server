package com.alkemy.ong.repository;

import com.alkemy.ong.domain.entity.ContactEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, UUID> {
}
