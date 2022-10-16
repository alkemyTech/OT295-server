package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;

import java.util.List;

public interface ContactService {

    ContactResponse create(ContactRequest contactRequest);

    List<ContactResponse> getAllContacts();
}
