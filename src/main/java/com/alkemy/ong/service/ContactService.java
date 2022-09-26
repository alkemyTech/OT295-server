package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.ContactRequest;
import com.alkemy.ong.domain.response.ContactResponse;

public interface ContactService {

    ContactResponse create(ContactRequest contactRequest);
}
