package com.alkemy.ong.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "app_roles")
public class RoleEntity {


    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
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
