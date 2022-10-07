package com.alkemy.ong.domain.request;

import lombok.*;


import java.util.UUID;

@Getter
@Setter
public class SlideRequest {
    
    private String text;
    //private Integer slideOrder;
    //private UUID organization;
    private String imageUrl;

}
