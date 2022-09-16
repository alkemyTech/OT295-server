package com.alkemy.ong.domain.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
@Table(name = "testimonials")
@SQLDelete(sql = "UPDATE testimonial SET softDelete = true WHERE id_testimonial = ?")
@Where(clause = "softDelete = false")
@Entity
public class TestimonialEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_testimonial")
    private Long idTestimonial;

    @NotNull ( message =  "Se debe ingresar el nombre")
    private String name;

    private String image;

    private String content;

    @Column(name = "soft_deleted")
    private boolean softDeleted;

    @CreationTimestamp
    @Column(name = "create_timestamp", updatable = false)
    private Timestamp createTimestamp;
}
