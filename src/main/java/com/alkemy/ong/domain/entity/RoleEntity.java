package com.alkemy.ong.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
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

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "create_timestamp")
    private Timestamp createTimestamp;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private List<UserEntity> usersList;

}
