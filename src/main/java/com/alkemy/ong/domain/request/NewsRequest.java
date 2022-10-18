package com.alkemy.ong.domain.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class NewsRequest {
    @Schema ( name = "name", example = "SOMO MAS")
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;

    @Schema ( name = "content" ,example = "SOMOS MAS se encarga de generar procesos de crecimientos hacia las personas")
    @NotBlank(message = "Content field can not be null or empty.")
    private String content;

    @Schema ( name = "imageUrl" , example = "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png")
    @NotBlank(message = "Image URL field can not be null or empty.")
    private String imageUrl;
}
