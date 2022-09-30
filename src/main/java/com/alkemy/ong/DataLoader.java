package com.alkemy.ong;

import com.alkemy.ong.domain.entity.RoleEntity;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;



public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public DataLoader(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setName("ROLE_ADMIN");
        roleEntity.setDescription("admin");
        RoleEntity role = roleRepository.save(roleEntity);
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(role);

 /*
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("admin_FN");
        userEntity.setLastName("admin_LN");
        userEntity.setEmail("admin@admin.com");
        userEntity.setUsername("admin");
        userEntity.setPassword("12345678");
        userEntity.setRoles(roles);
        userRepository.save(userEntity);
*/
    }
}
