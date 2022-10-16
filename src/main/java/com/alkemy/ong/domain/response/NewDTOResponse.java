package com.alkemy.ong.domain.response;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDTOResponse {

    private String name;

    private String content;

    private String imageUrl;

    private CategoryResponse category;

    private Timestamp timestamp;
}
