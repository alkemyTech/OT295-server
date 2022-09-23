package com.alkemy.ong.service.impl;

import com.alkemy.ong.auth.jwt.JwtUtils;
import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.dto.UserProfileDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.mapper.UserMapper;
import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public UserDTO patchUser(UserDTO userDTO, UUID userId) {
        UserEntity userEntity = this.getUserByID(userId);
        userEntity.setFirstName(userDTO.getFirstName());
        userEntity.setLastName(userDTO.getLastName());
        userEntity.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        userEntity.setEmail(userDTO.getEmail());
        return userMapper.entity2DTO(userRepository.save(userEntity));
    }



    //Uso de orElseThrow para implementar excepcion

    public UserEntity getUserByID(UUID userId){
        return userRepository.findById(userId).orElseThrow(
                ()->new ParamNotFound("User not found: "+ userId));
    }

    @Override
    public List<UserProfileDTO> readAllUsers() {
        //This method creates a list of users based on UserProfileDTO
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserProfileDTO> userProfileDTOList = new ArrayList<>();

        for (UserEntity user : userEntityList) {
            userProfileDTOList.add(userMapper.userEntity2UserProfileDTO(user));
        }

        return userProfileDTOList;
    }

    @Override
    public UserProfileDTO getUserProfile(HttpServletRequest request) {

        String email = null;
        String jwt = null;

        String authorizationHeader = request.getHeader("Authorization");
        jwt = authorizationHeader.substring(7);
        email = jwtUtils.decodeToken(jwt);

        UserEntity userEntity = userRepository.findByEmail(email);
        UserProfileDTO userProfileDTO = userMapper.userEntity2UserProfileDTO(userEntity);

        return userProfileDTO;
    }

    public void deleteUser(UUID userId){
        userRepository.delete(userRepository.findById(userId).orElseThrow(
        ()->new ParamNotFound("User not found: "+ userId)));
    }

}
