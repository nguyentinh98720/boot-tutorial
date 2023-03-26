/**
 * 
 */
package com.example.demo.repository;

import java.util.List;

import com.example.demo.entities.Car;

/**
 * @created Mar 26, 2023
 *
 */
public interface CarRepository {

    List<Car> findAll();

    Car findById(Long id);

    void save(Car entity);

    void delete(Car entity);

}
