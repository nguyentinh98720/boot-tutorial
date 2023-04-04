/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.demo.dtos.CarDto;
import com.example.demo.entities.dealer.Car;

/**
 * @created Mar 26, 2023
 *
 */
@Mapper
public interface CarMapper {

    CarDto toDto(Car entity);

    List<CarDto> toDto(List<Car> entities);

    Car toEntity(CarDto dto);

    Car updateEntity(CarDto dto, @MappingTarget Car entity);
}
