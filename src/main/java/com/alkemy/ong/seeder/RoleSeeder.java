package com.alkemy.ong.seeder;

import com.alkemy.ong.auth.security.RoleType;
import com.alkemy.ong.domain.entity.RoleEntity;
import com.alkemy.ong.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RoleSeeder implements CommandLineRunner {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {
        seedRoleTable(); }

    private void seedRoleTable(){
        if(roleRepository.count() == 0){
            createRole(RoleType.ADMIN);
            createRole(RoleType.USER);
        }
    }

    private void createRole(RoleType roleType){
        RoleEntity role = new RoleEntity();
        role.setName(roleType.getFullRoleName());
        role.setDescription(roleType.name());
        roleRepository.save(role);
    }
}
