package com.alkemy.ong.domain.request;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter

public class TestimonialRequest {

    @NotNull(message = "Name can not be empty or null")
    private String name;

    private String image;

    @NotNull(message = "Content can not be empty or null")
    private String content;

    private Timestamp createTimestamp;

}
