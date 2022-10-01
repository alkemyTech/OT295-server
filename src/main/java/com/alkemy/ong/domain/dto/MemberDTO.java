package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
@Setter
@Getter
public class MemberDTO {

    @NotBlank(message = "Name cannot be empty or null.")
    private String name;

    private String facebookUrl;

    private String instagramUrl;

    private String linkedinUrl;

    @NotBlank(message = "image cannot be empty or null.")
    private String image;

    private String description;
}
