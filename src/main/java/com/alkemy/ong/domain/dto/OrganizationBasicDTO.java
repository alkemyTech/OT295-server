package com.alkemy.ong.domain.dto;

import lombok.Getter;
import lombok.Setter;



@Getter
@Setter
public class OrganizationBasicDTO {
    private Long id;
    private String name;
    private String image;
    private int phone;
    private String address;

}
