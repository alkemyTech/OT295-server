package com.alkemy.ong.domain.entity;

import lombok.*;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {


    @Id
    @GeneratedValue
    @Type(type ="uuid-char")
    @Column(name = "id_rol", nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    private String description;

    @CreatedDate
    @Column(columnDefinition = "timestamp")
    private Timestamp timestamp;

}
