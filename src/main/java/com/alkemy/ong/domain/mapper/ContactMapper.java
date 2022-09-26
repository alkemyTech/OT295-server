package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.ContactEntity;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import org.springframework.stereotype.Component;

@Component
public class ContactMapper {

  public ContactResponse map(ContactEntity contact) {
    ContactResponse contactResponse = new ContactResponse();
    contactResponse.setName(contact.getName());
    contactResponse.setEmail(contact.getEmail());
    contactResponse.setPhone(contact.getPhone());
    contactResponse.setMessage(contact.getMessage());
    return contactResponse;
  }

  public ContactEntity map(ContactRequest contactRequest) {
    ContactEntity contact = new ContactEntity();
    contact.setName(contactRequest.getName());
    contact.setPhone(contactRequest.getPhone());
    contact.setEmail(contactRequest.getEmail());
    contact.setMessage(contactRequest.getMessage());
    return contact;
  }

}
