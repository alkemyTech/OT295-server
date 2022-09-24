package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
public class NewDTO {

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Content cannot be empty")
    private String content;

    @NotNull(message = "Image cannot be empty")
    private String imageUrl;

    @NotNull(message = "Category id cannot be empty")
    private UUID categoryId;

    private Timestamp timestamps;

}
