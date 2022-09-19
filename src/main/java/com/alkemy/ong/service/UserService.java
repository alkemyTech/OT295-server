package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.dto.UserProfileDTO;
import com.alkemy.ong.domain.entity.UserEntity;

import javax.servlet.http.HttpServletRequest;

public interface UserService {

    UserProfileDTO getUserProfile(HttpServletRequest request);

    void deleteUser(Long userId);

    UserDTO patchUser(UserDTO userDTO, Long userId);

    UserEntity getUserByID(Long userId);
}
