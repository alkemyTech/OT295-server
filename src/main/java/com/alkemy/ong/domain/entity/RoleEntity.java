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
@ToString
@EqualsAndHashCode
@Table(name = "roles")
public class RoleEntity {

    @Id
    @SequenceGenerator(name = "seq_roles", sequenceName = "seq_roles", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_roles")
    @Column(name = "id_roles", nullable = false)
    private Long idRoles;

    @Column(nullable = false)
    private String name;

    private String description;

    @CreatedDate
    @Column(columnDefinition = "timestamp")
    private Timestamp timestamp;

}
