/**
 * 
 */
package com.example.demo.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.CarDto;
import com.example.demo.service.CarService;

/**
 * @created Mar 26, 2023
 *
 */
@RestController
@RequestMapping("/api/car")
public class CarResource {

    @Autowired
    private CarService service;

    @GetMapping
    public ResponseEntity<List<CarDto>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDto> getCarById(@PathVariable(name = "id", required = true) Long id) {
        CarDto dto = service.getCarById(id);
        if (dto == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(dto);
        }
    }

    @PostMapping
    public ResponseEntity<CarDto> createCar(@RequestBody CarDto dto) {
        return ResponseEntity.ok(service.createNewCar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateCar(@PathVariable(name = "id", required = true) Long id, @RequestBody CarDto dto) {
        dto.setId(id);
        boolean success = service.updateExistingCar(dto);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeCar(@PathVariable(name = "id", required = true) Long id) {
        boolean success = service.removeExistingCar(id);
        if (success) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
