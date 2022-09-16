package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.OrganizationEntity;
import com.alkemy.ong.domain.dto.OrganizationDTO;
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
    OrganizationDTO toOrganizationDTO(OrganizationEntity organization);
    List<OrganizationDTO> toOrganizationDTOList(List<OrganizationEntity> organizations);

    @InheritInverseConfiguration
    OrganizationEntity toOrganizationEntity(OrganizationDTO organizationDTO);
}
