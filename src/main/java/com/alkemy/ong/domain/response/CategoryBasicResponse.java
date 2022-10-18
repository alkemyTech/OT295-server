package com.alkemy.ong.domain.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ApiModel
public class CategoryBasicResponse {

    @Schema(example = "Category number 1")
    @NotBlank(message = "Name field can not be null or empty.")
    private String name;
}
