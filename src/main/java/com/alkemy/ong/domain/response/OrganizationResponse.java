package com.alkemy.ong.domain.response;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class OrganizationResponse {

    private UUID id;

    private String name;

    private String image;

    private String email;

    private String address;

    private Integer phone;

    private String welcomeText;

    private String aboutUsText;

    private String urlInstagram;

    private String urlFacebook;

    private String urlLinkedin;
}
