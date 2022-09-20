package com.alkemy.ong.service;

import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.domain.dto.UserProfileDTO;
import com.alkemy.ong.domain.entity.UserEntity;
import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

public interface UserService {

    UserProfileDTO getUserProfile(HttpServletRequest request);

    void deleteUser(UUID userId);

    UserDTO patchUser(UserDTO userDTO, UUID userId);

    UserEntity getUserByID(UUID userId);
}
