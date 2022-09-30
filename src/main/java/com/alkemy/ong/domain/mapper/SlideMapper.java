package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.SlideDTOImageOrder;
import com.alkemy.ong.domain.entity.SlideEntity;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SlideMapper {

    private final OrganizationService organizationService;
    private final OrgMapper orgMapper;
    public SlideEntity DTO2Entity(SlideRequest slideRequest) {
        SlideEntity entity = new SlideEntity();
        entity.setText(slideRequest.getText());
        entity.setImageUrl(slideRequest.getImage_b64());
        //entity.setOrganizationId(slideRequest.getOrganization() != null || slideRequest.getOrganization().equals("") ? organizationService.getById(slideRequest.getOrganization()).getId() : null);
        return entity;
    }

    public SlideResponse entity2DtoResponse(SlideEntity entity) {
        SlideResponse dto = new SlideResponse();
        dto.setImageUrl(entity.getImageUrl());
        dto.setText(entity.getText());
        //dto.setSlideOrder(entity.getSlideOrder());
        /*if (entity.getOrganizationId() != null) {
            dto.setOrganization(orgMapper.entity2DTO(
                    organizationService.getById(entity.getOrganizationId())));
        }
        */
        return dto;
    }

    public SlideDTOImageOrder entity2DTOImageOrder(SlideEntity slideEntity){
        SlideDTOImageOrder slideDTOImageOrder = new SlideDTOImageOrder();
        slideDTOImageOrder.setImageUrl(slideEntity.getImageUrl());
        slideDTOImageOrder.setSlideOrder(slideEntity.getSlideOrder());

        return slideDTOImageOrder;
    }

}
