package com.alkemy.ong.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestimonialRepository  extends JpaRepository<TestimonialRepository, Long> {
}
