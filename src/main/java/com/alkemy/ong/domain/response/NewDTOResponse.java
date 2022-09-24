package com.alkemy.ong.domain.response;

import com.alkemy.ong.domain.dto.CategoryDTO;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDTOResponse {

    private String name;

    private String content;

    private String imageUrl;

    private CategoryDTO category;

    private Timestamp timestamp;
}
