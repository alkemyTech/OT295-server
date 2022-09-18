package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ParamNotFound;
import com.alkemy.ong.repository.UserRepository;
import com.alkemy.ong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    //Uso de orElseThrow para implementar excepcion
    public void deleteUser(Long id){
        userRepository.delete(userRepository.findById(id).orElseThrow(
        ()->new ParamNotFound("Param not found: "+ id)));
    }

}
