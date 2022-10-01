package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.ContactEntity;
import com.alkemy.ong.domain.mapper.ContactMapper;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ContactServiceImpl implements ContactService {

    private ContactMapper contactMapper;
    private ContactRepository contactRepository;

    @Autowired
    public ContactServiceImpl(ContactMapper contactMapper, ContactRepository contactRepository) {
        this.contactMapper = contactMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponse create(ContactRequest contactRequest) {
        ContactEntity contact = contactMapper.map(contactRequest);
        return contactMapper.map(contactRepository.save(contact));
    }

    @Override
    public List<ContactResponse> getAllContacts() {
        List<ContactEntity> entities = contactRepository.findAll();
        List<ContactResponse> result = contactMapper.contactEntity2DTOList(entities);
        return result;
    }
}
