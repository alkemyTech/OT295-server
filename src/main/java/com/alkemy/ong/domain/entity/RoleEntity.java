package com.alkemy.ong.domain.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//A Revisar el uso de ToString y EqualsAndHashCode en entidades
@ToString
@EqualsAndHashCode
@Table(name = "roles")
public class RoleEntity {

    //A revisar GenerationType IDENTITY o SEQUENCE
    @Id
    @SequenceGenerator(name = "seq_roles", sequenceName = "seq_roles", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roles")
    @Column(name = "id_rol", nullable = false)
    private Long idRol;

    @Column(nullable = false)
    private String name;

    private String description;

    @CreatedDate
    @Column(columnDefinition = "timestamp")
    private Timestamp timestamp;

}
