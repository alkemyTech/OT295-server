package com.alkemy.ong.domain.response;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationResponse {

    private String username;
    private String token;
    public AuthenticationResponse(String username, String token) {
        this.username = username;
        this.token = token;
    }

    public AuthenticationResponse() {
    }
}

