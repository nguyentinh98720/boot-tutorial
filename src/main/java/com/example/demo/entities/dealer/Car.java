/**
 * 
 */
package com.example.demo.entities.dealer;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.demo.entities.AbstractAuditingEntity;

/**
 * @created Mar 26, 2023
 *
 */
@Entity
@Table(name = "car")
public class Car extends AbstractAuditingEntity<Long> {

    private static final long serialVersionUID = 6517177107040400497L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    private double price;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
