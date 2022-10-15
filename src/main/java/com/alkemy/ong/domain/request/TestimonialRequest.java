package com.alkemy.ong.domain.request;

import lombok.*;


import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Getter
@Setter

public class TestimonialRequest {

    @NotBlank(message = "Name can not be empty or null")
    private String name;

    private String image;

    @NotBlank(message = "Content can not be empty or null")
    private String content;



}
