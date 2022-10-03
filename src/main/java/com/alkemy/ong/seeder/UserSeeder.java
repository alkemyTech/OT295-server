package com.alkemy.ong.seeder;

import com.alkemy.ong.auth.security.RoleType;
import com.alkemy.ong.domain.entity.RoleEntity;
import com.alkemy.ong.domain.entity.UserEntity;
import com.alkemy.ong.repository.RoleRepository;
import com.alkemy.ong.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class UserSeeder implements CommandLineRunner {

    private static final List<String> NAMES_ADMIN = List.of("Enzo", "Leandro", "Lionel", "Julian", "Admin", "Enzo", "Nicolas", "Gonzalo", "Rodrigo", "Lautaro");
    private static final List<String> LAST_NAMES_ADMIN = List.of("Fernandez", "Paredes", "Messi", "Alvarez", "Admin", "Perez", "Otamendi", "Montiel", "De Paul", "Martinez");
    private static final List<String> EMAILS_ADMIN = List.of("enzo@gmail.com", "leandro@gmail.com", "lionel@gmail.com", "admin@gmail.com",
            "enzop@gmail.com", "nicolas@gmail.com", "gonzalo@gmail.com", "rodrigo@gmail.com", "lautaro@gmail.com", "julian@gmail.com");
    private static final List<String> PASSWORDS_ADMIN = List.of("11111111", "22222222", "33333333", "44444444", "55555555", "66666666", "7777777", "88888888", "9999999", "123456789");
    private static final List<String> NAMES_USER = List.of("Cristina", "Maria", "Sandra", "Romina", "Rocio", "Miriam", "Laura", "Franco", "Angel", "Marta");
    private static final List<String> LAST_NAMES_USER = List.of("Rodriguez", "Rivadavia", "Martinez", "Gonzales", "Rosales", "Suarez", "Flores", "Armani", "Di Maria", "Ramirez");
    private static final List<String> EMAILS_USER = List.of("cristina@gmail.com", "maria@gmail.com", "sandra@gmail.com", "romina@gmail.com",
            "rocio@gmail.com", "miriam@gmail.com", "laura@gmail.com", "franco@gmail.com", "angel@gmail.com", "marta@gmail.com");
    private static final List<String> PASSWORDS_USER = List.of("11111111", "2222222", "33333333",
            "44444444", "55555555", "66666666", "7777777", "88888888", "9999999", "123456789");

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) {
        seedUserTable();
    }

    private void seedUserTable() {
        if (userRepository.count() == 0) {
            createAdminUsers();
            createStandardUsers();
        }
    }

    private void createAdminUsers() {
        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findByName(RoleType.ADMIN.getFullRoleName()));
        roles.add(roleRepository.findByName(RoleType.USER.getFullRoleName()));

        for (int index = 0; index < 10; index++) {
            createUser(NAMES_ADMIN.get(index),
                    LAST_NAMES_ADMIN.get(index),
                    EMAILS_ADMIN.get(index),
                    PASSWORDS_ADMIN.get(index),
                    roles);
        }
    }

    private void createStandardUsers() {
        List<RoleEntity> roleUser = Collections.singletonList(
                roleRepository.findByName(RoleType.USER.getFullRoleName()));

        for (int index = 0; index < 10; index++) {
            createUser(NAMES_USER.get(index),
                    LAST_NAMES_USER.get(index),
                    EMAILS_USER.get(index),
                    PASSWORDS_USER.get(index),
                    roleUser);
        }
    }

    private void createUser(String firstName, String lastName, String email, String password,
                            List<RoleEntity> role) {
        UserEntity user = new UserEntity();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setSoftDelete(false);
        userRepository.save(user);
        user.setRoles(role);
        userRepository.save(user);
    }
}
