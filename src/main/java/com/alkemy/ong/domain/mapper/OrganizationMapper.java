package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.response.OrganizationResponse;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "address", target = "address")
    })
    OrganizationBasicDTO toOrganizationBasicDTO(OrganizationEntity organization);

    List<OrganizationBasicDTO> toOrganizationBasicDTOList(List<OrganizationEntity> organizations);

    @InheritInverseConfiguration
    OrganizationEntity toOrganizationEntity(OrganizationBasicDTO organizationBasicDTO);

    @Mappings({
            @Mapping(source = "id", target = "id"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "image", target = "image"),
            @Mapping(source = "phone", target = "phone"),
            @Mapping(source = "address", target = "address"),
            @Mapping(source = "mail", target = "mail"),
            @Mapping(source = "welcomeText", target = "welcomeText"),
            @Mapping(source = "aboutUsText", target = "aboutUsText")
    })
    OrganizationResponse entityToDto(OrganizationEntity organization);
}
