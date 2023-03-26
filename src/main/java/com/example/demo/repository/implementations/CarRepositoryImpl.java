/**
 * 
 */
package com.example.demo.repository.implementations;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.demo.entities.Car;
import com.example.demo.repository.CarRepository;

/**
 * @created Mar 26, 2023
 *
 * TODO use JPARepository
 * Đối với repository layout có nhiều cách triển khai khác nhau 
 * Tìm hiểu và áp dụng Spring data jpa
 * 
 */
@Repository
public class CarRepositoryImpl implements CarRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Car> findAll() {

        String query = "SELECT * FROM car";

        // FIXME Unsafe type
        List<Car> result = entityManager.createNativeQuery(query, Car.class).getResultList();

        return result;
    }

    @Override
    public Car findById(Long id) {
        return entityManager.find(Car.class, id);
    }

    @Override
    @Transactional
    /*
     * TODO Tìm hiểu về transaction trong sql, hibernate và spring data jpa
     */
    public void save(Car entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void delete(Car entity) {
        entityManager.remove(entity);
    }

}
