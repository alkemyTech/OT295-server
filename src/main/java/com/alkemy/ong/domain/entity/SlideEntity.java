package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "slides")
public class SlideEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;


    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "text")
    private String text;

    @Column(name = "slide_order")
    private Integer slideOrder;

/*
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", insertable = false, updatable = false, foreignKey = @ForeignKey(name = "id"))
    // Solo para buscar informacion
    private OrganizationEntity organization;

    @Column(name = "organization_id", nullable = true) // Para guardar y actualizar
    private UUID organizationId;
*/
}

