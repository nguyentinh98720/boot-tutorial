/**
 * 
 */
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.dtos.CarDto;
import com.example.demo.service.CarService;

/**
 * @created Mar 26, 2023
 *
 */
@Controller
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService service;

    private static final String REDIRECTING_PAGE = "redirect:/car";

    @GetMapping
    public String getListOfCar(Model model) {
        List<CarDto> carDtos = service.getAllCars();
        model.addAttribute("cars", carDtos);
        return "listCars";
    }

    @GetMapping("/add")
    public String addCarPage(Model model) {
        model.addAttribute("car", new CarDto());
        return "createCar";
    }

    @PostMapping("/add")
    public String afterAddingNewCar(@ModelAttribute("car") CarDto dto) {
        service.createNewCar(dto);
        return REDIRECTING_PAGE;
    }

    @PostMapping("/remove/{id}")
    public String afterRemovingCar(@PathVariable Long id) {
        service.removeExistingCar(id);
        return REDIRECTING_PAGE;
    }

    @GetMapping("/update/{id}")
    public String updateCarPage(@PathVariable Long id, Model model) {
        CarDto carDto = service.getCarById(id);
        model.addAttribute("car", carDto);
        return "updateCar";
    }

    @PostMapping("/update/{id}")
    public String afterUpdatingCar(@ModelAttribute("car") CarDto dto, @PathVariable Long id) {
        dto.setId(id);
        service.updateExistingCar(dto);
        return REDIRECTING_PAGE;
    }
}
