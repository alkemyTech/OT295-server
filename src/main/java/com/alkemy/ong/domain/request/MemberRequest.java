package com.alkemy.ong.domain.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {

    private UUID id;

    @NotBlank(message = "Name cannot be null or empty.")
    @Pattern(regexp = "^[A-Za-z]*$", message = "The name has to contain only letters")
    @Schema(name="name", example = "John")
    private String name;

    @Schema(name="facebookUrl", example = "www.facebook.com/johndoe")
    private String facebookUrl;

    @Schema(name="instagramUrl", example = "www.instagram.com/johndoe")
    private String instagramUrl;

    @Schema(name="linkedinUrl", example = "www.linkedin.com/johndoe")
    private String linkedinUrl;

    @Schema(name="image", example = "this is a image's url")
    private String image;

    @Schema(name="description", example = "this is a description of a member")
    private String description;


}
