package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {

    private UUID id;
    private String name;
    private String description;
    private String image;
    private Timestamp createTimestamp;
}
