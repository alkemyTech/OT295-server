package com.alkemy.ong.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.UUID;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
@ApiModel
public class CategoryResponse {

    @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(example = "Category number 1")
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;

    @Schema(example = "This is a description")
    private String description;

    @Schema(example = "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png")
    private String image;

    private Timestamp createTimestamp;

    public CategoryResponse(UUID id, String name, String description, String image, Timestamp createTimestamp) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.createTimestamp = createTimestamp;
    }

    public CategoryResponse() {
    }
}
