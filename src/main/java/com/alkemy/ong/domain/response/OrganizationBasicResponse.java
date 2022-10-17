package com.alkemy.ong.domain.response;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class OrganizationBasicResponse {
  
  private String name;
  private String image;
  private int phone;
  private String address;

}
