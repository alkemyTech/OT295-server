package com.alkemy.ong.domain.entity;


import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ACTIVITIES")
public class ActivitiesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACTIVITIES_ID")
    private Long activitiesId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CONTENT", nullable = false)
    private String content;

    @Column(name = "IMAGE_URL", nullable = false)
    private String imageUrl;

    @CreationTimestamp
    @Column(name = "CREATE_TIMESTAMP", updatable = false)
    private Timestamp createTimestamp;

    @Column(name = "SOFT_DELETED")
    private boolean softDeleted;

}
