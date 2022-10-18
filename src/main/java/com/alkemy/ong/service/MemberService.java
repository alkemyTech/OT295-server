package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.MemberResponse;

import java.util.List;
import java.util.UUID;

public interface MemberService {

    MemberResponse update(UUID id, MemberRequest request);

    MemberResponse save(MemberRequest request);

    void delete(UUID id);

    List<MemberResponse> getMembers();

    MemberPageResponse getAllMember(Integer page);
}
