package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.dto.UserProfileDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public BasicUserDTO entity2BasicDTO(UserEntity userEntity){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BasicUserDTO result = new BasicUserDTO();
        result.setFirstName(userEntity.getFirstName());
        result.setLastName(userEntity.getLastName());
        return result;
    }

    //Rever Segunda implementacion de basicDTO2Entity
    public UserDTO entity2DTO(UserEntity entity) {
        UserDTO dto = new UserDTO();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPassword(entity.getPassword());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserProfileDTO userEntity2UserProfileDTO(UserEntity entity) {
        UserProfileDTO userProfileDto = new UserProfileDTO();

        userProfileDto.setEmail(entity.getEmail());
        userProfileDto.setFirstName(entity.getFirstName());
        userProfileDto.setLastName(entity.getLastName());
        return userProfileDto;
    }

}
