package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    private ContactRepository contactRepository;
    private ContactService contactService;

    @Autowired
    public ContactController(ContactRepository contactRepository, ContactService contactService) {
        this.contactRepository = contactRepository;
        this.contactService = contactService;
    }

    @PostMapping
    public ResponseEntity<ContactResponse> create(
            @Valid @RequestBody ContactRequest contactRequest) {
        ContactResponse contactResponse = contactService.create(contactRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(contactResponse);
    }
    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAll(){
        List<ContactResponse> contacts = contactService.getAllContacts();
        return ResponseEntity.ok().body(contacts);
    }
}
