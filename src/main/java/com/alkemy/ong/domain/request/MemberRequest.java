package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberRequest {

    @NotBlank(message = "Name cannot be null or empty.")
    @Pattern(regexp = "^[A-Za-z]*$", message = "The name has to contain only letters")
    private String name;

    private String facebookUrl;

    private String instagramUrl;

    private String linkedinUrl;

    private String image;

    private String description;
}
