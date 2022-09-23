package com.alkemy.ong.domain.entity;


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
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SQLDelete(sql = "UPDATE activities SET soft_delete = true WHERE id = ?")
@Where(clause = "soft_delete=false")
@Entity
@Table(name = "activities")
public class ActivityEntity {

    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    @Column(name = "id")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "image_url", nullable = false)
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "create_timestamp", updatable = false)
    private Timestamp createTimestamp;

    @Column(name = "soft_delete")
    private Boolean softDelete = Boolean.FALSE;

}
