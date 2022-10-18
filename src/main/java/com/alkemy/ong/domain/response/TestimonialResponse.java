package com.alkemy.ong.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class TestimonialResponse {

    @Schema(name="name", example = "Juan")
    public String name;

    @Schema(name = "content", example = "This is a testimonial")
    public String content;
}
