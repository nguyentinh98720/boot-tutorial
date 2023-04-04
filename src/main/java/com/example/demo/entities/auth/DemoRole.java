/**
 * 
 */
package com.example.demo.entities.auth;

import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.entities.AbstractAuditingEntity;
import com.example.demo.enums.DemoPermission;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @since Apr 1, 2023
 *
 */
@Entity
@Table(name = "role")
@SuperBuilder
@NoArgsConstructor
@Getter
public class DemoRole extends AbstractAuditingEntity<Long> {

    private static final long serialVersionUID = 7232100373273066739L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", length = 100, nullable = true, unique = true)
    private String code;

    @Column(name = "name", length = 200)
    private String name;

    // TODO use cache
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "role_permission")
    private Set<DemoPermission> permissions;
}
