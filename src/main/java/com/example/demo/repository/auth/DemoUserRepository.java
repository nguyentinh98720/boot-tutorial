/**
 * 
 */
package com.example.demo.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.auth.DemoUser;

/**
 * @since Apr 4, 2023
 *
 */
public interface DemoUserRepository extends JpaRepository<DemoUser, Long> {

    Optional<DemoUser> findByEmailIgnoreCase(String email);
}
