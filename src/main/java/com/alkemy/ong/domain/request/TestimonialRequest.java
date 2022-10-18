package com.alkemy.ong.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;


import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter

public class TestimonialRequest {

    @NotBlank(message = "Name can not be empty or null")
    @Schema(name="name", example = "Juan")
    private String name;
    @Schema(name="name", example = "this is a image's url")
    private String image;

    @NotBlank(message = "Content can not be empty or null")
    @Schema(name = "content", example = "This is a testimonial")
    private String content;



}
