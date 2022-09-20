package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AuthenticationRequest {
    @Email(message = "Username must be email")
    private String email;
    @Size(min = 8)
    private String password;
}

