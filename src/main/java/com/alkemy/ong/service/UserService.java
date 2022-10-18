package com.alkemy.ong.service;

import com.alkemy.ong.domain.request.UserRequest;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.domain.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

    UserResponse getUserProfile(String request);

    void deleteUser(UUID userId);

    UserResponse patchUser(UserRequest userRequest, UUID userId);

    UserEntity getUserByID(UUID userId);

    List<UserResponse> readAllUsers();
}
