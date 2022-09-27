package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.request.UserRequest;
import com.alkemy.ong.domain.dto.UserProfileDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public BasicUserDTO entity2BasicDTO(UserEntity userEntity){

        BasicUserDTO result = new BasicUserDTO();
        result.setFirstName(userEntity.getFirstName());
        result.setLastName(userEntity.getLastName());
        result.setRole(userEntity.getRoles().get(0).getName());
        return result;
    }

    //Rever Segunda implementacion de basicDTO2Entity
    public UserResponse entity2DTO(UserEntity entity) {
        UserResponse dto = new UserResponse();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
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
