package com.alkemy.ong.service.impl;


import com.alkemy.ong.domain.entity.ContactEntity;
import com.alkemy.ong.domain.mapper.ContactMapper;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import com.alkemy.ong.repository.ContactRepository;
import com.alkemy.ong.service.ContactService;
import org.springframework.stereotype.Service;


@Service
public class ContactServiceImpl implements ContactService {

    private ContactMapper contactMapper;
    private ContactRepository contactRepository;

    @Override
    public ContactResponse create(ContactRequest contactRequest) {
        ContactEntity contact = contactMapper.map(contactRequest);
        return contactMapper.map(contactRepository.save(contact));
    }
}
