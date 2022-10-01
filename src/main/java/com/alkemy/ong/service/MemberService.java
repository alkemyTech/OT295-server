package com.alkemy.ong.service;
import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;

import java.util.UUID;

public interface MemberService {
    MemberDTO update(UUID id, MemberDTO member);

    MemberResponse save(MemberRequest request);

    void delete(UUID id);
}
