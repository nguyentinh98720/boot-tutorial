/**
 * 
 */
package com.example.demo.entities.auth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.entities.AbstractAuditingEntity;
import com.example.demo.enums.GenderEnum;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @since Apr 1, 2023
 *
 */
@Entity
@Table(name = "user")
@NoArgsConstructor
@SuperBuilder
@Getter
public class DemoUser extends AbstractAuditingEntity<Long> {

    private static final long serialVersionUID = 507514001439079820L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", length = 100, nullable = false)
    private String email;

    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "gender", length = 15)
    @Enumerated(EnumType.STRING)
    private GenderEnum gender;

    @Column(name = "hash_password", length = 60)
    private String password;

    @Column(name = "activated")
    private boolean activated;
}
