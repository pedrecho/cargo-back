package com.kursach.controller;


import com.kursach.entity.Car;
import com.kursach.repository.CarRepository;
import com.kursach.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    private final CarRepository car;

    CarController(CarRepository car) {
        this.car = car;
    }

    @GetMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public Optional<Car> GetById(@PathVariable(name = "id") Long id) {
        return this.car.findById(id);
    }

    @PostMapping(path = "/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Delete(@PathVariable(name = "id") Long id) {
        return carService.Delete(id);
    }

    @GetMapping
    @PreAuthorize("hasAuthority('USER')")
    public List<Car> GetAll() {
        return this.car.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public HttpStatus Save(Car car) {
        return carService.Save(car);
    }
}