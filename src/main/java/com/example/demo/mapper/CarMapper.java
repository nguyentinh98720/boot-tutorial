/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.example.demo.dtos.CarDto;
import com.example.demo.entities.Car;

/**
 * @created Mar 26, 2023
 *
 */
// TODO use default component model setting when compiling
@Mapper(componentModel = "spring")
public interface CarMapper {

    CarDto toDto(Car entity);

    List<CarDto> toDto(List<Car> entities);

    Car toEntity(CarDto dto);

    Car updateEntity(CarDto dto, @MappingTarget Car entity);
}
