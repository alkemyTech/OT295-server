package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.domain.entity.MemberEntity;
import com.alkemy.ong.domain.entity.NewsEntity;
import com.alkemy.ong.domain.mapper.MemberMapper;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.domain.response.NewsResponse;
import com.alkemy.ong.domain.response.NewsResponsePage;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

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
    public List<MemberResponse> getMembers() {
        List<MemberEntity> entities = repository.findAll();
        List<MemberResponse> result = mapper.memberEntityTOResponse(entities);
        return result;
    }


    @Override
    public MemberResponse save(MemberRequest request) {
        MemberEntity member = mapper.map(request);
        return mapper.map(repository.save(member));
    }

    @Override
    public MemberPageResponse getAllMember(Integer page) {
        MemberPageResponse response=new MemberPageResponse();
        Pageable pageable=PageRequest.of(page, 10);
        Page<MemberEntity> memberPage=repository.findAll(pageable);
        int totalElements=(int) memberPage.getTotalElements();
        Page<MemberResponse> responses=new PageImpl<MemberResponse>(memberPage.getContent()
                .stream()
                .map(member->new MemberResponse(
                        member.getName(),
                        member.getDescription(),
                        member.getImage(),
                        member.getInstagramUrl(),
                        member.getFacebookUrl(),
                        member.getLinkedinUrl()))
                .collect(Collectors.toList()),pageable,totalElements);
        response.setResponses(responses);
        if((pageable.getPageNumber()+1)>0 && (pageable.getPageNumber()+1)<responses.getTotalPages()){
            response.setPreviousPage("localhost:8080/members/page/" + (pageable.getPageNumber() - 1));
            response.setNextPage("localhost:8080/members/page/" + (pageable.getPageNumber() + 1));}
        if((pageable.getPageNumber()+1)==responses.getTotalPages()){
            response.setPreviousPage("localhost:8080/members/page/" + (pageable.getPageNumber() - 1));
            response.setNextPage("nonexistent next page");}
        if(pageable.getPageNumber()==0){
            response.setPreviousPage("nonexistent previous page");
            response.setNextPage("localhost:8080/members/page/" + (pageable.getPageNumber() + 1));}
        return response;
    }


}
