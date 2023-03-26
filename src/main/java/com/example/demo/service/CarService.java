/**
 * 
 */
package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.CarDto;

/**
 * @created Mar 26, 2023
 *
 */
public interface CarService {

    /**
     * @return all existing cars
     */
    List<CarDto> getAllCars();

    /**
     * @param id the id of car
     * @return cardto
     */
    CarDto getCarById(Long id);

    /**
     * @param dto car data to create
     * @return cardto
     */
    CarDto createNewCar(CarDto dto);

    /**
     * @param dto car data to update
     * @return boolean success or failed
     */
    boolean updateExistingCar(CarDto dto);

    /**
     * @param id id of car to remove
     * @return boolean success or failed
     */
    boolean removeExistingCar(Long id);

}
