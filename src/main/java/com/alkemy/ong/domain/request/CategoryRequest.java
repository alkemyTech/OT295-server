package com.alkemy.ong.domain.request;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
public class CategoryRequest {

    @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @NotBlank(message = "Name cannot be empty or null.")
    @Pattern(regexp = "^[a-zA-Z ]+$", message = "The name has to contain only letters")
    @Schema(example = "Category number 1")
    private String name;

    @NotBlank(message = "Description cannot be empty or null.")
    @Schema(example = "This is a description")
    private String description;

    @NotBlank(message = "Image cannot be empty or null.")
    @Schema(example = "image.png")
    private String image;
}
