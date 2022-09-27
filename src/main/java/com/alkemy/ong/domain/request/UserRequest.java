package com.alkemy.ong.domain.request;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserRequest {

    @NotBlank(message = "First name can not be empty")
    private String firstName;

    @NotBlank(message = "Last name can not be empty")
    private String lastName;

    @NotBlank(message = "Email can not be empty")
    @Email(message = "Email is not valid")
    private String email;
    
    @Size(min = 8)
    private String password;

    private String token;

}
