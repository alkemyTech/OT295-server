package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserResponse entity2BasicDTO(UserEntity userEntity){

        UserResponse result = new UserResponse();
        result.setFirstName(userEntity.getFirstName());
        result.setLastName(userEntity.getLastName());
        result.setRole(userEntity.getRoles().get(0).getName());
        return result;
    }


    public UserResponse entity2DTO(UserEntity entity) {
        UserResponse dto = new UserResponse();
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setEmail(entity.getEmail());
        return dto;
    }

    public UserResponse userEntity2UserProfileDTO(UserEntity entity) {
        UserResponse userProfileDto = new UserResponse();

        userProfileDto.setEmail(entity.getEmail());
        userProfileDto.setFirstName(entity.getFirstName());
        userProfileDto.setLastName(entity.getLastName());
        return userProfileDto;
    }

}
