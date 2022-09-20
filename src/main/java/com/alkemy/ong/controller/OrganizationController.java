package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.OrganizationBasicDTO;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/organization")
public class OrganizationController {
    @Autowired
    private OrganizationService service;

    @GetMapping("/public/{id}")
    public ResponseEntity<OrganizationBasicDTO> getOrganization(@PathVariable UUID id){
        OrganizationBasicDTO organization = service.getOrganization(id);
        return ResponseEntity.ok().body(organization);
    }
}
