package com.alkemy.ong.domain.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CategoryRequest {
    @NotBlank(message = "Name cannot be empty or null.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "The name has to contain only letters")
    @ApiModelProperty(example = "Category number 1",
            required = true,
            position = 0)
    private String name;

    @NotBlank(message = "Description cannot be empty or null.")
    @ApiModelProperty(example = "This is a description",
            position = 1)
    private String description;

    @NotBlank(message = "Image cannot be empty or null.")
    @ApiModelProperty(example = "image.png",
            position = 2)
    private String image;
}
