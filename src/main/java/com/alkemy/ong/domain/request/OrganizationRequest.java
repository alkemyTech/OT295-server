package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter

public class OrganizationRequest {

  @NotBlank(message = "Name field can not be null or empty.")
  private String name;

  @NotBlank(message = "Image field can not be null or empty.")
  private String image;

  @Email(message = "Email has invalid format.")
  @NotBlank(message = "Email field can not be null or empty.")
  private String email;

  @NotBlank(message = "address text field can not be null or empty.")
  private String address;

  private Integer phone;

  @NotBlank(message = "Welcome text field can not be null or empty.")
  private String welcomeText;

  @NotBlank(message = "About Text text field can not be null or empty.")
  private String aboutUsText;

  @NotBlank(message = "urlInstagram text field can not be null or empty.")
  private String urlInstagram;

  @NotBlank(message = "urlFacebook text field can not be null or empty.")
  private String urlFacebook;

  @NotBlank(message = "urlLinkedin text field can not be null or empty.")
  private String urlLinkedin;






}
