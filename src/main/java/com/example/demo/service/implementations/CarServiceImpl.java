/**
 * 
 */
package com.example.demo.service.implementations;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.CarDto;
import com.example.demo.entities.Car;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repository.CarRepository;
import com.example.demo.service.CarService;

/**
 * @created Mar 26, 2023
 *
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository repository;

    @Autowired
    private CarMapper mapper;

    @Override
    public List<CarDto> getAllCars() {

        List<Car> cars = repository.findAll();

        return mapper.toDto(cars);
    }

    @Override
    public CarDto getCarById(Long id) {

        Car car = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        return mapper.toDto(car);
    }

    @Override
    public CarDto createNewCar(CarDto dto) {

        Car newCar = mapper.toEntity(dto);

        repository.save(newCar);

        return mapper.toDto(newCar);
    }

    @Override
    public boolean updateExistingCar(CarDto dto) {

        Long carId = dto.getId();

        Car existingCar = repository.findById(carId)
                .orElseThrow(EntityNotFoundException::new);

        existingCar = mapper.updateEntity(dto, existingCar);

        repository.save(existingCar);

        return true;
    }

    @Override
    public boolean removeExistingCar(Long id) {

        Car existingCar = repository.findById(id)
                .orElseThrow(EntityNotFoundException::new);

        repository.delete(existingCar);

        return true;
    }

}
