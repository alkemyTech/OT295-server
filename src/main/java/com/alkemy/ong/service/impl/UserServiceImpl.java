package com.alkemy.ong.service.impl;

import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.mapper.UserMapper;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public UserDTO patchUser(UserDTO userDTO, Long userId) {
        UserEntity userEntity = this.getUserByID(userId);
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userEntity.setEmail(userDTO.getEmail());
        return userMapper.basicDTO2Entity(userRepository.save(userEntity));
    }



    //Uso de orElseThrow para implementar excepcion

    public UserEntity getUserByID(Long userId){
        return userRepository.findById(userId).orElseThrow(
                ()->new ParamNotFound("User not found: "+ userId));
    }

    public void deleteUser(Long userId){
        userRepository.delete(userRepository.findById(userId).orElseThrow(
        ()->new ParamNotFound("Param not found: "+ userId)));
    }

}
