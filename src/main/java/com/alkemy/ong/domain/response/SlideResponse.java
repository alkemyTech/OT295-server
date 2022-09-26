package com.alkemy.ong.domain.response;

import com.alkemy.ong.domain.request.OrganizationRequest;
import lombok.*;

@Getter
@Setter
public class SlideResponse {
    private String text;
    private Integer slideOrder;
    private String imageUrl;
    private OrganizationRequest organization;
}
