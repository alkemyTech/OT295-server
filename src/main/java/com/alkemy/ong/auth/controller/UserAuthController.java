package com.alkemy.ong.auth.controller;


import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.auth.service.UserDetailsCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    UserDetailsCustomService userDetailsService;

    @PostMapping("/register")
    public ResponseEntity<BasicUserDTO> signup(@Valid @RequestBody UserDTO user)throws Exception {
        BasicUserDTO result =  this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }

}
