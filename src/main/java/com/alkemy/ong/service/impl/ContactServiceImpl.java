package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.ContactEntity;
import com.alkemy.ong.domain.mapper.ContactMapper;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import com.alkemy.ong.service.EmailServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    private ContactMapper contactMapper;
    private ContactRepository contactRepository;

    @Autowired
    private EmailServiceInterface emailService;

    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponse create(ContactRequest contactRequest) {
        ContactEntity contact = contactMapper.map(contactRequest);
        ContactEntity contactCreated = contactRepository.save(contact);

        //MAIL VALIDATION WHEN A CONTACT IS CREATED
        if (contactCreated != null) {

            emailService.sendEmailTo(contactCreated.getEmail(), "contact");
        }

        return contactMapper.map(contactCreated);
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        List<ContactEntity> entities = contactRepository.findAll();
        List<ContactResponse> result = contactMapper.contactEntity2DTOList(entities);
        return result;
    }
}
