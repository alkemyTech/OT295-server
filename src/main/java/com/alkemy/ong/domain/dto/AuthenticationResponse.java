package com.alkemy.ong.domain.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {
    private String username;
    private String email;
    private String token;
    public AuthenticationResponse(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public AuthenticationResponse() {
    }
}

