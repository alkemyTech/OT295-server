package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class ActivityRequest {

    @NotBlank(message = "Name field can not be null or empty.")
    private String name;

    @NotBlank(message = "Content field can not be null or empty.")
    private String content;

    private String imageUrl;

}
