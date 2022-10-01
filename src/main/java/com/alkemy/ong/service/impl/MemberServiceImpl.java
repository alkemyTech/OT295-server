package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.dto.MemberDTO;
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

    @Autowired
    MemberRepository memberRepository;
    @Autowired
    MemberMapper memberMapper;

    @Override
    public MemberDTO update(UUID id, MemberDTO member) {
        Optional<MemberEntity> entity= this.memberRepository.findById(id);
        if(!entity.isPresent()){
            throw new ParamNotFound("Id not valid");
        }
        this.memberMapper.memberEntityRefreshValues(entity.get(), member);
        MemberEntity entitySaved = this.memberRepository.save(entity.get());
        MemberDTO result = this.memberMapper.memberEntity2DTO(entitySaved);

        return result;
    }
}
