package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewsRequest {
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;

    @NotBlank(message = "Content field can not be null or empty.")
    private String content;

    @NotBlank(message = "Image URL field can not be null or empty.")
    private String imageUrl;
}
