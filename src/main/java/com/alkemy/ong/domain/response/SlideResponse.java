package com.alkemy.ong.domain.response;

import com.alkemy.ong.domain.request.OrganizationRequest;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
public class SlideResponse {

    private UUID id;
    private String text;
    private Integer slideOrder;
    private String imageUrl;
    private OrganizationResponse organization;
}
