package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.mapper.OrganizationMapper;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationBasicResponse;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrganizationServiceImpl implements OrganizationService {


    private final OrganizationMapper mapper;

    private final OrganizationRepository repository;


    public OrganizationBasicResponse save(OrganizationRequest request){
        return mapper.entity2BasicDTOResponse(repository.save(mapper.DTO2Entity(request)));
    }

    public OrganizationResponse getPublicInformation(UUID id) {
        return mapper.entity2DTOResponse((getById(id)));
    }

   /* @Override
    public List<OrganizationResponse> getOrganizations() {
        List<OrganizationEntity> entityList = repository.findAll();
            List<OrganizationResponse> result = mapper.toOrganizationResponseList(entityList);
        return new ArrayList<>();
    }*/

    @Override
    public OrganizationResponse update(OrganizationRequest organizationRequest) {
        OrganizationEntity organization=repository.findByEmail(organizationRequest.getEmail());
        if(organization.getEmail().isEmpty()){
            throw new ParamNotFound("organization not found");
        }
        organization.setName(organizationRequest.getName());
        organization.setImage(organizationRequest.getImage());
        organization.setAddress(organizationRequest.getAddress());
        organization.setPhone(organizationRequest.getPhone());
        organization.setEmail(organizationRequest.getEmail());
        organization.setWelcomeText(organizationRequest.getWelcomeText());
        organization.setAboutUsText(organizationRequest.getAboutUsText());
        organization.setUrlFacebook(organizationRequest.getUrlFacebook());
        organization.setUrlInstagram(organizationRequest.getUrlInstagram());
        organization.setUrlLinkedin(organization.getUrlLinkedin());
        return mapper.entity2DTOResponse(repository.save(organization));

    }

    public void delete(UUID id){
        repository.delete(getById(id));
    }

    public OrganizationEntity getById(UUID id) {
        return repository.findById(id).orElseThrow(
                () -> new ParamNotFound("Organization not found"));
    }

}
