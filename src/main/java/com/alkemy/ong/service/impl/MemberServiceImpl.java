package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.MemberService;
import com.alkemy.ong.domain.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberMapper mapper;
    private MemberRepository repository;

    @Autowired
    public MemberServiceImpl(MemberMapper mapper, MemberRepository repository) {
        this.mapper = mapper;
        this.repository = repository;
    }

    @Override
    public MemberDTO update(UUID id, MemberDTO member) {
        Optional<MemberEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id not valid");
        }
        this.mapper.memberEntityRefreshValues(entity.get(), member);
        MemberEntity entitySaved = this.repository.save(entity.get());
        MemberDTO result = this.mapper.memberEntity2DTO(entitySaved);

        return result;
    }

    @Override
    public void delete(UUID id) {
        Optional<MemberEntity> entity = this.repository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Id not valid");
        }
        this.repository.delete(entity.get());
    }


    @Override
    public MemberResponse save(MemberRequest request) {
        MemberEntity member = mapper.map(request);
        return mapper.map(repository.save(member));
    }


}
