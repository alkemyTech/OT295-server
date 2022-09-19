package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class UserProfileDTO {
    private String firstName;
    private String lastName;
    @Email
    private String email;
}
