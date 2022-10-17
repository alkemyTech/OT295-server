package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.OrganizationRequest;
import com.alkemy.ong.domain.response.OrganizationBasicResponse;
import com.alkemy.ong.domain.response.OrganizationResponse;
import com.alkemy.ong.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/organization")
public class OrganizationController {


    private OrganizationService service;

    @Autowired
    public OrganizationController(@Lazy OrganizationService service) {
        this.service = service;
    }

    @GetMapping("/public/{id}")
    public ResponseEntity<OrganizationResponse> publicInformation(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(service.getPublicInformation(id));
    }

    @PostMapping
    public ResponseEntity<OrganizationBasicResponse> save(@Valid @RequestBody OrganizationRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request));
    }

    @PostMapping(value = "/public")
    public ResponseEntity<OrganizationResponse> update(@Valid @RequestBody OrganizationRequest organizationRequest) {
        OrganizationResponse organization = service.update(organizationRequest);
        return ResponseEntity.ok().body(organization);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}