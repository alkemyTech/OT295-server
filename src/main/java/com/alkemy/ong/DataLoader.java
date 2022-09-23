package com.alkemy.ong;

import com.alkemy.ong.domain.entity.RoleEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
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
        roleEntity.setDescription("admin_D");
        roleRepository.save(roleEntity);
        Set<RoleEntity> roles = new HashSet<>();
        roles.add(roleEntity);

//        String password = passwordEncoder.encode("admin");
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName("admin_FN");
        userEntity.setLastName("admin_LN");
        userEntity.setEmail("admin_email");
        userEntity.setUsername("admin");
        userEntity.setPassword("admin");
        userEntity.setRoles(roles);
        userRepository.save(userEntity);

    }
}
