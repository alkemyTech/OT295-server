package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.SlideDTOImageOrder;
import com.alkemy.ong.domain.entity.SlideEntity;
import com.alkemy.ong.domain.request.SlideRequest;
import com.alkemy.ong.domain.response.SlideResponse;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class SlideMapper {


    private OrganizationService organizationService;

    private OrganizationMapper organizationMapper;

    @Autowired
    public SlideMapper(@Lazy OrganizationService organizationService, OrganizationMapper organizationMapper) {
        this.organizationService = organizationService;
        this.organizationMapper = organizationMapper;
    }
    public SlideEntity DTO2Entity(SlideRequest slideRequest) {
        SlideEntity entity = new SlideEntity();
        entity.setText(slideRequest.getText());
        entity.setImageUrl(slideRequest.getImageUrl());
        entity.setOrganizationId(slideRequest.getOrganization() != null || slideRequest.getOrganization().equals("") ? organizationService.getById(slideRequest.getOrganization()).getId() : null);
        return entity;
    }

    public SlideResponse entity2DtoResponse(SlideEntity entity) {
        SlideResponse dto = new SlideResponse();
        dto.setId(entity.getId());
        dto.setImageUrl(entity.getImageUrl());
        dto.setText(entity.getText());
        dto.setSlideOrder(entity.getSlideOrder());
       /*if (entity.getOrganizationId() != null) {
            dto.setOrganization(organizationMapper.entity2BasicDTOResponse(
                    organizationService.getById(entity.getOrganizationId())));
        }*/
        return dto;
    }

    public SlideDTOImageOrder entity2DTOImageOrder(SlideEntity slideEntity){
        SlideDTOImageOrder slideDTOImageOrder = new SlideDTOImageOrder();
        slideDTOImageOrder.setImageUrl(slideEntity.getImageUrl());
        slideDTOImageOrder.setSlideOrder(slideEntity.getSlideOrder());

        return slideDTOImageOrder;
    }

}
