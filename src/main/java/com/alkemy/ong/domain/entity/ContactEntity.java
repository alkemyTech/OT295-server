package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.UUID;

@Getter
@Setter
@SQLDelete(sql = "UPDATE contacts SET soft_delete = true WHERE id = ?")
@Where(clause = "deleted=false")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="contacts")
public class ContactEntity {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private Integer phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "message", nullable = false)
    private String message;

    @Column(name = "soft_delete")
    private Boolean deletedAt = Boolean.FALSE;
}
