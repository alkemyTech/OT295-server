package com.alkemy.ong.domain.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewDTOResponse {

    @Schema(name = "name", example = "SOMOS MAS")
    private String name;

    @Schema(name = "content", example = "SOMOS MAS se encarga de generar procesos de crecimientos hacia las personas")
    private String content;

    @Schema(name = "imageUrl", example = "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png")
    private String imageUrl;

    private CategoryResponse category;

    private Timestamp timestamp;
}
