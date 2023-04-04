/**
 * 
 */
package com.example.demo.configuration.security;

import java.util.Optional;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.demo.entities.auth.DemoRole;
import com.example.demo.entities.auth.DemoTitle;
import com.example.demo.entities.auth.DemoUser;
import com.example.demo.repository.auth.DemoRoleRepository;
import com.example.demo.repository.auth.DemoTitleRepository;
import com.example.demo.repository.auth.DemoUserRepository;

/**
 * @since Apr 4, 2023
 *
 */
@Component
public class InitializeAuthentication implements InitializingBean {

    @Autowired
    DemoUserRepository userRepository;
    
    @Autowired
    DemoTitleRepository titleRepository;
    
    @Autowired
    DemoRoleRepository roleRepository;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void afterPropertiesSet() throws Exception {
        // just for test
        final String defaultUserEmail = "admin@test.com";
        final String defaultUserPassword = "abc@123";
        final String defaultCode = "ADMIN";
        
        DemoUser user;
        Optional<DemoUser> userOptional = userRepository.findByEmailIgnoreCase(defaultUserEmail);
        if (userOptional.isPresent()) {
            user = userOptional.get();
        } else {
            user = DemoUser.builder()
                    .email(defaultUserEmail)
                    .password(passwordEncoder.encode(defaultUserPassword))
                    .firstName("Admin")
                    .activated(true)
                    .build();
            userRepository.save(user);
        }
        
        DemoRole role;
        Optional<DemoRole> roleOptional = roleRepository.findByCodeAndDeletedFalse(defaultCode);
        if (roleOptional.isPresent()) {
            role = roleOptional.get();
        } else {
            role = DemoRole.builder()
                    .code(defaultCode)
                    .name("Role " + defaultCode)
                    .build();
            roleRepository.save(role);
        }
        
        Optional<DemoTitle> titleOptional = titleRepository.findByUserIdAndRoleIdAndDeletedFalseAndPrimaryTitleTrue(user.getId(), role.getId());
        if (titleOptional.isEmpty()) {
            DemoTitle title = DemoTitle.builder()
                    .userId(user.getId())
                    .roleId(role.getId())
                    .primaryTitle(true)
                    .build();
            titleRepository.save(title);
        }
    }
}
