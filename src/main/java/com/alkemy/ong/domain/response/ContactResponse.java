package com.alkemy.ong.domain.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContactResponse {

    private String name;

    private Integer phone;

    private String email;

    private String message;
}
