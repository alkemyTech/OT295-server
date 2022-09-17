package com.alkemy.ong.domain.entity;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
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
@SQLDelete(sql = "UPDATE members SET soft_Delete = true WHERE idMember = ? ")
@Where(clause = "soft_Delete = false")
@Table(name = "members")
public class MemberEntity {

    //A revisar GenerationType IDENTITY o SEQUENCE
    @Id
    @SequenceGenerator(name = "seq_members", sequenceName = "seq_members", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_members")
    @Column(name = "id_member", nullable = false)
    private Long idMember;

    @Column(nullable = false)
    private String name;

    @Column(name = "facebook_url")
    private String facebookUrl;

    @Column(name = "instagram_url")
    private String instagramUrl;

    @Column(name = "linkedin_url")
    private String linkedinUrl;

    @Column(nullable = false)
    private String image;

    private String description;

    @CreatedDate
    @Column(name = "timestamp")
    private Timestamp timestamp;

    @Column(name = "soft_Delete")
    private boolean softDelete = Boolean.FALSE;
}
