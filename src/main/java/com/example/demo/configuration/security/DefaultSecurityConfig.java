/**
 * 
 */
package com.example.demo.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @since Apr 4, 2023
 *
 */
@Configuration
public class DefaultSecurityConfig {

    @Bean
    SecurityFilterChain basicSecurityFilterChain(HttpSecurity http) throws Exception {
        // @formatter:off
        http
            .authorizeRequests()
                .antMatchers("/swagger-ui.html", "/swagger-ui/index.html").permitAll()
                .anyRequest().authenticated()
//                .anyRequest().permitAll()
            .and()
            .httpBasic();
        // @formatter:on
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
