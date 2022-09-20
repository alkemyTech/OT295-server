package com.alkemy.ong.domain.dto;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
public class UserDTO {

    private String firstName;
    private String lastName;
    @Email(message = "Username must be email")
    private String email;
    @Size(min = 8)
    private String password;

}
