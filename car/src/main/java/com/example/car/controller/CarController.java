package com.example.car.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.car.model.Car;
import com.example.car.repository.CarRepository;
import com.example.car.service.CarService;

@RestController
@RequestMapping("/cars-api")
public class CarController {

    @Autowired
    private CarService service;

    // GET http://localhost:8989/cars-api
    @GetMapping
    public List<Car> getAllCars() {
        return service.getAllCars();
    }

    // GET http://localhost:8989/cars-api/1
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id) {
        return service.getCarById(id);
    }

    // DELETE http://localhost:8989/cars-api/600000/800000
    @DeleteMapping("/{minPrice}/{maxPrice}")
    public String deleteByPriceRange(@PathVariable double minPrice,
                                     @PathVariable double maxPrice) {
        service.deleteCarsByPriceRange(minPrice, maxPrice);
        return "Cars deleted successfully";
    }

    // GET http://localhost:8989/cars-api/Honda/2020
    @GetMapping("/{make}/{year}")
    public List<Car> getCarsByMakeAndYear(@PathVariable String make,
                                          @PathVariable int year) {
        return service.getCarsByMakeAndYear(make, year);
    }

    // PUT http://localhost:8989/cars-api/Honda
    @PutMapping("/{make}")
    public Car updateCar(@PathVariable String make,
                          @RequestBody Car car) {
        return service.updateCarByMake(make, car);
    }

    // POST http://localhost:8989/cars-api
    @PostMapping
    public String addCar(@RequestBody Car car) {
        service.addCar(car);
        return "Car added successfully";
    }
}

