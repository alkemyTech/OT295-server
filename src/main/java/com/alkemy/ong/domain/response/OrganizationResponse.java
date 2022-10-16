package com.alkemy.ong.domain.response;


import com.alkemy.ong.domain.entity.SlideEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter

public class OrganizationResponse {
  
  private String name;
  private String image;
  private int phone;
  private String address;
  private String URLInstagram;
  private String URLFacebook;
  private String URLLinkedin;
  private List<SlideEntity> slides;








}
