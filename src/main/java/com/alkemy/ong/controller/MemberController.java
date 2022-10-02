package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.repository.MemberRepository;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberRepository memberRepository;
    private MemberService service;

    @Autowired
    public MemberController(MemberRepository memberRepository, MemberService service) {
        this.memberRepository = memberRepository;
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMembers() {
        List<MemberResponse> members = service.getMembers();
        return ResponseEntity.ok().body(members);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> update(@PathVariable UUID id, @RequestBody MemberDTO member) {
        MemberDTO result = this.service.update(id, member);
        return ResponseEntity.ok().body(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<MemberResponse> create(@Valid @RequestBody MemberRequest request) {
        MemberResponse member = service.save(request);
        return ResponseEntity.ok().body(member);
    }
}