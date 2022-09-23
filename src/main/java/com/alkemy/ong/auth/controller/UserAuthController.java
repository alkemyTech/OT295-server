package com.alkemy.ong.auth.controller;


import com.alkemy.ong.auth.jwt.JwtUtils;
import com.alkemy.ong.auth.service.UserDetailsCustomService;
import com.alkemy.ong.domain.dto.*;
import com.alkemy.ong.domain.request.AuthenticationRequest;
import com.alkemy.ong.domain.response.AuthenticationResponse;
import com.alkemy.ong.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserAuthController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsCustomService userDetailsService;

    //Required=false hace que levante el proyecto pero no creo que sea correcto
    @Autowired(required = false)
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtTokenUtil;

    @PostMapping("/register")
    public ResponseEntity<BasicUserDTO> signup(@Valid @RequestBody UserDTO user) throws Exception {
        BasicUserDTO result = this.userDetailsService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);

    }
    @PostMapping("/login")
    public ResponseEntity<Object> login(@Valid @RequestBody AuthenticationRequest authenticationRequest) {
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword(), null)
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            return ResponseEntity.ok("false");
        }
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(userDetails.getUsername(), jwt));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileDTO> getProfile(HttpServletRequest request) {

        UserProfileDTO dto = userService.getUserProfile(request);
        return ResponseEntity.ok().body(dto);
    }


}
