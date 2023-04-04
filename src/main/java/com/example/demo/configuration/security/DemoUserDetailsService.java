/**
 * 
 */
package com.example.demo.configuration.security;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.entities.auth.DemoRole;
import com.example.demo.entities.auth.DemoTitle;
import com.example.demo.entities.auth.DemoUser;
import com.example.demo.enums.DemoPermission;
import com.example.demo.repository.auth.DemoRoleRepository;
import com.example.demo.repository.auth.DemoTitleRepository;
import com.example.demo.repository.auth.DemoUserRepository;

/**
 * @since Apr 4, 2023
 *
 */
@Service
public class DemoUserDetailsService implements UserDetailsService {

    @Autowired
    private DemoUserRepository userRepository;

    @Autowired
    private DemoTitleRepository titleRepository;

    @Autowired
    private DemoRoleRepository roleRepository;

    // FIXME need to refactor this method
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<DemoUser> userOptional = userRepository.findByEmailIgnoreCase(username);

        if (userOptional.isEmpty()) {
            throw new UsernameNotFoundException("Tài khoản " + username + " không có trong hệ thống!");
        }

        DemoUser user = userOptional.get();

        List<DemoTitle> titles = titleRepository.findAllByUserIdAndDeletedFalse(user.getId());

        Optional<DemoTitle> primaryTitleOptional = titles.stream().filter(DemoTitle::isPrimaryTitle).findAny();
        if (primaryTitleOptional.isEmpty()) {
            // this method return here
            return new DemoUserDetails(user, new HashSet<>());
        }

        DemoTitle primaryTitle = primaryTitleOptional.get();

        Optional<DemoRole> roleOptional = roleRepository.findById(primaryTitle.getRoleId());
        if (roleOptional.isEmpty()) {
            // this method return here
            return new DemoUserDetails(user, new HashSet<>());
        }

        Set<DemoPermission> permissions = roleOptional.get().getPermissions();
        return new DemoUserDetails(user, permissions);
    }

}
