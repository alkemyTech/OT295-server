package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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



    private MemberService service;
    @Autowired
    public MemberController(@Lazy MemberService service) {
        this.service = service;
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<MemberResponse>> getMembers() {
        List<MemberResponse> members = service.getMembers();
        return ResponseEntity.ok().body(members);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<MemberResponse> update(@PathVariable UUID id, @RequestBody MemberRequest member) {
        MemberResponse result = this.service.update(id, member);
        return ResponseEntity.ok().body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
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

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    public ResponseEntity<MemberPageResponse> getAll(@PathVariable Integer page) {
        MemberPageResponse member = service.getAllMember(page);
        return ResponseEntity.ok().body(member);
    }
}