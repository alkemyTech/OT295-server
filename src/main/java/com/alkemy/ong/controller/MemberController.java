package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.MemberDTO;
import com.alkemy.ong.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/members")
public class MemberController {
    @Autowired
    MemberService memberService;

    @PutMapping("/{id}")
    public ResponseEntity<MemberDTO> update(@PathVariable UUID id, @RequestBody MemberDTO member) {
        MemberDTO result = this.memberService.update(id, member);
        return ResponseEntity.ok().body(result);
    }
}
