package com.alkemy.ong.controller;

import com.alkemy.ong.domain.request.UserRequest;
import com.alkemy.ong.domain.response.UserResponse;
import com.alkemy.ong.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PatchMapping("/{id}")
    public ResponseEntity<UserResponse> patchUser(@PathVariable UUID userId, @RequestBody UserRequest userRequest) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                this.userService.patchUser(userRequest, userId));
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable UUID userId){
        this.userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping()
    public ResponseEntity<?> readAllUsers(){
        return new ResponseEntity<>(userService.readAllUsers(),HttpStatus.OK);
    }
}
