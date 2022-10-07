package com.alkemy.ong.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "organizations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE organizations SET soft_delete = true WHERE id=?")
@Where(clause = "soft_delete=false")
public class OrganizationEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "image", nullable = false)
    private String image;

    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    private Integer phone;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "welcome_text", nullable = false)
    private String welcomeText;

    @Column(name = "about_us_text")
    private String aboutUsText;

    @Column (name = "URL_Instragram")
    private String URLInstragram;

    @Column (name = "URL_Facebook")
    private String URLFacebook;

    @Column (name = "URL_Linkedin")
    private String URLLinkedin;

    @CreationTimestamp
    @Column(name = "create_timestamp")
    private Timestamp createTimestamp;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;

/*
    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private Set<SlideEntity> slidesList;


*/
}