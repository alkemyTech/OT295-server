package com.alkemy.ong.domain.request;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Getter
@Setter
public class SlideRequest {
    
    private String text;
    private Integer slideOrder;
    private UUID organization;
    private MultipartFile image_b64;

}
