package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.OrganizationEntity;
import com.alkemy.ong.domain.mapper.OrganizationMapper;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationBasicResponse;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.OrganizationRepository;
import com.alkemy.ong.service.OrganizationService;
import com.alkemy.ong.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationMapper mapper;

    private OrganizationRepository repository;

    private SlideService service;
    @Autowired
    public OrganizationServiceImpl(OrganizationRepository repository, OrganizationMapper mapper,@Lazy SlideService service) {
        this.repository = repository;
        this.mapper = mapper;
        this.service = service;
    }

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
        Optional<OrganizationEntity> result = repository.findById(id);
        if (result.isPresent()){
            OrganizationEntity entity = result.get();
            entity.setSlidesList(service.slidesForOrg(id));
            repository.save(entity);
            return entity;
        } else {
            throw  new ParamNotFound("Organization not found or disabled");
        }
    }

}
