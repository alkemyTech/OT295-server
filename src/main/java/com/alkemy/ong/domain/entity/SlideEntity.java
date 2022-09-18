package com.alkemy.ong.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

    @Entity
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @Table(name = "slides")
    public class SlideEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_slide")
        private Long idSlide;

        @Column(name = "image_url")
        private String imageUrl;

        private String text;
        private String order;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "organization_id",insertable = false, updatable = false) // Solo para buscar informacion
        private OrganizationEntity organization;

        @Column(name = "organization_id", nullable = false) // Para guardar y actualizar
        private Long organizationId;
}

