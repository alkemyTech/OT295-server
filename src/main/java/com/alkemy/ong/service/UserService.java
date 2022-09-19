package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.entity.UserEntity;

public interface UserService {

    void deleteUser(Long userId);

    UserDTO patchUser(UserDTO userDTO, Long userId);

    UserEntity getUserByID(Long userId);
}
