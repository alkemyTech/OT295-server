package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql="UPDATE users SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
@Table(name = "users")
public class UserEntity implements UserDetails {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private UUID id;

    @Column(name= "first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name ="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;


    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private List<RoleEntity> roleEntities;


    @Column(name="deleted")
    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name = "create_timestamp", updatable = false)
    private Timestamp createTimestamp;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.getRoleEntities().stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return !this.deleted;
    }
}
