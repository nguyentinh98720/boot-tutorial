/**
 * 
 */
package com.example.demo.repository.auth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.auth.DemoRole;

/**
 * @since Apr 4, 2023
 *
 */
public interface DemoRoleRepository extends JpaRepository<DemoRole, Long> {

    Optional<DemoRole> findByCodeAndDeletedFalse(String code);

}
