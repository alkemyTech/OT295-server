package com.alkemy.ong.auth.controller;


import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.auth.service.UserDetailsCustomService;
import com.alkemy.ong.domain.response.ErrorResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
@Api(tags = "Authentication Endpoints", value = "AuthenticationEndpoints")
public class UserAuthController {
    @Autowired
    UserDetailsCustomService userDetailsService;

    @PostMapping("/register")
    @ApiResponse(code = 403, message = "PERMISSION_DENIED - Forbidden.",
            response = ErrorResponse.class)
    public ResponseEntity<BasicUserDTO> signup(@Valid @RequestBody UserDTO user)throws Exception {
        BasicUserDTO result =  this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}
