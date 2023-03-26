/**
 * 
 */
package com.example.demo.mapper.implementations;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.dtos.CarDto;
import com.example.demo.entities.Car;
import com.example.demo.mapper.CarMapper;

/**
 * @created Mar 26, 2023
 * 
 * TODO use mapstruct - Tìm hiểu thêm tại sao nên dùng dto (data
 * transfer object pattern) - Hiện tại đang mapping thủ công và công
 * việc phải lặp đi lặp lại nhiều lần cho các method lẫn model khác -->
 * Tìm hiểu và áp dụng thêm mapstruct
 */
@Component
public class CarMapperImpl implements CarMapper {

    @Override
    public CarDto toDto(Car entity) {

        if (entity == null) {
            return null;
        }

        CarDto dto = new CarDto();

        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());

        return dto;
    }

    @Override
    public List<CarDto> toDto(List<Car> entities) {
        List<CarDto> dtos = new ArrayList<>();
        for (Car entity : entities) {
            dtos.add(toDto(entity));
        }
        return dtos;
    }

    @Override
    public Car toEntity(CarDto dto) {

        if (dto == null) {
            return null;
        }

        Car entity = new Car();

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());

        return entity;
    }

    @Override
    public Car updateEntity(CarDto dto, Car entity) {

        if (dto == null || entity == null) {
            return null;
        }

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());

        return entity;
    }
}
