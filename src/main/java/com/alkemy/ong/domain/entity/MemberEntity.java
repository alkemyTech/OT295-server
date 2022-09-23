package com.alkemy.ong.domain.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE members SET soft_Delete = true WHERE idMember = ? ")
@Where(clause = "soft_Delete = false")
@Table(name = "members")
public class MemberEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id_member", nullable = false)
    private UUID id;


    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "facebook_url")
    private String facebookUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "description")
    private String description;

    @CreationTimestamp
    @Column(name = "create_timestamp")
    private Timestamp createTimestamp;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;
}
