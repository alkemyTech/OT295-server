package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
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
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
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
