package com.alkemy.ong.domain.mapper;

import com.alkemy.ong.domain.dto.BasicUserDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public BasicUserDTO basicDto2Entity(UserEntity userEntity){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        BasicUserDTO result = new BasicUserDTO();
        result.setFirstName(userEntity.getFirstName());
        result.setLastName(userEntity.getLastName());
        return result;
    }
}
