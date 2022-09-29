package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.CategoryBasicDTO;
import com.alkemy.ong.domain.entity.CategoryEntity;
import com.alkemy.ong.domain.entity.ContactEntity;
import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

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


  public List<ContactResponse> contactEntity2DTOList(List<ContactEntity> entities) {
    List<ContactResponse> dtos = new ArrayList<>();
    for (ContactEntity entity : entities) {
      dtos.add(this.map(entity));
    }
    return dtos;
  }
}
