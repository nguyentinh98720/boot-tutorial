/**
 * 
 */
package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.Car;

/**
 * @created Mar 26, 2023
 *
 */
public interface CarRepository extends JpaRepository<Car, Long> {

}
