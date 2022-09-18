package com.alkemy.ong.auth.service;

import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.mapper.UserMapper;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsCustomService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(userName);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Username or password not found");
        }
        return new User(userEntity.getEmail(), userEntity.getPassword(), Collections.emptyList());
    }

    public BasicUserDTO save(UserDTO userDTO) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setEmail(userDTO.getEmail());
        userEntity.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        userEntity = this.userRepository.save(userEntity);
        BasicUserDTO result = userMapper.basicDto2Entity(userEntity);
        return result;

    }
}
