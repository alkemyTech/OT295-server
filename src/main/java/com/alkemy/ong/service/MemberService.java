package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.MemberDTO;

import java.util.UUID;

public interface MemberService {
    MemberDTO update(UUID id, MemberDTO member);

    void delete(UUID id);
}
