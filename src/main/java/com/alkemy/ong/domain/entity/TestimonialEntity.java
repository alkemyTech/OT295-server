package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "testimonials")
@SQLDelete(sql = "UPDATE testimonials SET softDelete = true WHERE id= ?")
@Where(clause = "softDelete = false")
@Entity
public class TestimonialEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @NotNull ( message =  "Name must be entered")
    private String name;

    private String image;

    private String content;

    @Column(name = "soft_deleted")
    private boolean softDeleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name = "create_timestamp", updatable = false)
    private Timestamp createTimestamp;
}
