package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<OrganizationBasicDTO> getOrganization(@PathVariable Long id) {
        OrganizationBasicDTO organization = service.getOrganization(id);
        return ResponseEntity.ok().body(organization);
    }

    @PostMapping(value = "/public")
    public ResponseEntity<OrganizationResponse> update(@Valid @RequestBody OrganizationRequest organizationRequest) {
        OrganizationResponse organization = service.update(organizationRequest);
        return ResponseEntity.ok().body(organization);
    }
}