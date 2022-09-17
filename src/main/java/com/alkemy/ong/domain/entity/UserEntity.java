package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql="UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToOne()
    @JoinColumn(name= "role_id", insertable = false, updatable = false)
    private RoleEntity role;

    @Column (name="role_id", nullable = false)
    private Long roleId;

    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name = "CREATE_TIMESTAMP", updatable = false)
    private Timestamp createTimestamp;
}
