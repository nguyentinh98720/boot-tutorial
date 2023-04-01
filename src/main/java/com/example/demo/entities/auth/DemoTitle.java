/**
 * 
 */
package com.example.demo.entities.auth;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.entities.AbstractAuditingEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @since Apr 1, 2023
 *
 */
@Entity
@Table(name = "title")
@SuperBuilder
@NoArgsConstructor
@Getter
public class DemoTitle extends AbstractAuditingEntity<Long> {

    private static final long serialVersionUID = 7603899375133460427L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    private Long roleId;

    private String definition;
}
