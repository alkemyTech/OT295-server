package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/public")
    public ResponseEntity<List<OrganizationResponse>> getOrganization() {
        List<OrganizationResponse> organization = service.getOrganizations();
        return ResponseEntity.ok().body(organization);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping(value = "/public")
    public ResponseEntity<OrganizationResponse> update(@Valid @RequestBody OrganizationRequest organizationRequest) {
        OrganizationResponse organization = service.update(organizationRequest);
        return ResponseEntity.ok().body(organization);
    }
}