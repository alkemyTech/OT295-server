package com.alkemy.ong.auth.service;

import com.alkemy.ong.auth.jwt.JwtUtils;
import com.alkemy.ong.auth.security.RoleType;
import com.alkemy.ong.domain.request.AuthenticationRequest;
import com.alkemy.ong.domain.response.AuthenticationResponse;
import com.alkemy.ong.domain.request.UserRequest;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.mapper.UserMapper;
import com.alkemy.ong.domain.response.UserResponse;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.EmailServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDetailsCustomService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private JwtUtils jwtUtil;

    @Autowired
    private EmailServiceInterface emailService;


    @Autowired
    @Lazy
    private AuthenticationManager authenticationManager;


    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getAuthorities());
    }

    public UserResponse save(UserRequest userRequest) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userRequest.getFirstName());
        userEntity.setLastName(userRequest.getLastName());
        userEntity.setEmail(userRequest.getEmail());
        userEntity.setUsername(userRequest.getEmail());
        userEntity.setRoles(List.of(roleRepository.findByName(RoleType.ADMIN.getFullRoleName())));
        userEntity.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        UserResponse result = userMapper.entity2DTO(userRepository.save(userEntity));
        result.setToken(jwtUtil.generateToken(userEntity));

        //MAIL VALIDATION WHEN AN USER IS CREATED
        if (userEntity != null) {
            emailService.sendEmailTo(userEntity.getEmail(), "welcome");
        }
        return result;

    }



    public AuthenticationResponse login(AuthenticationRequest authenticationRequest)
            {
        UserEntity user = userRepository.findByEmail(authenticationRequest.getUsername());
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()));

        return new AuthenticationResponse(user.getUsername(), jwtUtil.generateToken(user));
    }

}
