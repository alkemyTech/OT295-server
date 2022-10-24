package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.MemberRequest;
import com.alkemy.ong.domain.response.MemberPageResponse;
import com.alkemy.ong.domain.response.MemberResponse;
import com.alkemy.ong.service.MemberService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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
    @Operation(summary = "Get a list of information about all members", description = "This endpoint get all the information about all members")
    @ApiResponse(content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = MemberResponse.class))))
    public ResponseEntity<List<MemberResponse>> getMembers() {
        List<MemberResponse> members = service.getMembers();
        return ResponseEntity.ok().body(members);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    @Operation(summary = "Update information about a member", description = "This endpoint requires a member ID and Body to perform update of information")
    public ResponseEntity<MemberResponse> update(@PathVariable @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") UUID id, @RequestBody MemberRequest member) {
        MemberResponse result = this.service.update(id, member);
        return ResponseEntity.ok().body(result);
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete information about a member", description = "This endpoint requires a member ID to perform delete of information")
    public ResponseEntity<Void> delete(@PathVariable @Schema(example = "3fa85f64-5717-4562-b3fc-2c963f66afa6") UUID id) {
        this.service.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @PostMapping
    @Operation(summary = "Create a Member through a MemberRequest", description = "This endpoint inserts a new member")
    public ResponseEntity<MemberResponse> create(@Parameter(description = "It is a body in JSON format with the entity's atributes")@Valid @RequestBody MemberRequest request) {
        MemberResponse member = service.save(request);
        return ResponseEntity.ok().body(member);
    }

    @PreAuthorize("hasAnyRole('ROLE_USER'),('ROLE_ADMIN')")
    @GetMapping("/page/{page}")
    @Operation(summary = "Get a paginated list of member with minimal information", description = "This endpoint retrieves a paginated list of members containing minimal information")
    public ResponseEntity<MemberPageResponse> getAll(@PathVariable @Schema(example = "1")Integer page) {
        MemberPageResponse member = service.getAllMember(page);
        return ResponseEntity.ok().body(member);
    }
}