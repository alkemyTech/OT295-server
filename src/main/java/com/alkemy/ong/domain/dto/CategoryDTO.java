package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class CategoryDTO {

    private UUID id;
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;
    private String description;
    private String image;
    private Timestamp createTimestamp;

    public CategoryDTO(UUID id, String name, String description, String image, Timestamp createTimestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTimestamp = createTimestamp;
    }

    public CategoryDTO() {
    }
}
