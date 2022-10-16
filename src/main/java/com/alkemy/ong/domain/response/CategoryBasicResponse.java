package com.alkemy.ong.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel
public class CategoryBasicResponse {

    @ApiModelProperty(example = "Category number 1",
            position = 1)
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;
}
