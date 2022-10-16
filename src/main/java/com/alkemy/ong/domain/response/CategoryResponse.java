package com.alkemy.ong.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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

    @ApiModelProperty(example = "1",
            position = 0)
    private UUID id;

    @ApiModelProperty(example = "Category number 1",
            position = 1)
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;

    @ApiModelProperty(example = "This is a description",
            position = 2)
    private String description;

    @ApiModelProperty(example = "https://s3.us-east-1.amazonaws.com/cohorte-septiembre-5efe33c6/1665545315223-logoEmpres.png")
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
