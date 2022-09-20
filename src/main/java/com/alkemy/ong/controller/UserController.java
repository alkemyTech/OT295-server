package com.alkemy.ong.controller;

import com.alkemy.ong.domain.dto.UserDTO;
import com.alkemy.ong.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    @PatchMapping("/{id}")
    public ResponseEntity<UserDTO> patchUser(@PathVariable UUID userId, @RequestBody UserDTO userDTO) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                this.userService.patchUser(userDTO, userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
