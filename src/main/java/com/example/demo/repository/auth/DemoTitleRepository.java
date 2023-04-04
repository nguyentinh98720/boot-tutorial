/**
 * 
 */
package com.example.demo.repository.auth;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.auth.DemoTitle;

/**
 * @since Apr 4, 2023
 *
 */
public interface DemoTitleRepository extends JpaRepository<DemoTitle, Long> {

    List<DemoTitle> findAllByUserIdAndDeletedFalse(Long id);

    Optional<DemoTitle> findByUserIdAndRoleIdAndDeletedFalseAndPrimaryTitleTrue(Long userId, Long roleId);

}
