package com.alkemy.ong.domain.request;

import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ContactRequest {
    @NotBlank(message = "Name cannot be empty or null.")
    private String name;

    @NotNull(message = "Phone cannot be null.")
    private Integer phone;

    @Email(message = "Email is not valid.")
    @NotBlank(message = "Email cannot be empty or null.")
    private String email;

    @NotBlank(message = "Message cannot be empty or null.")
    private String message;
}
