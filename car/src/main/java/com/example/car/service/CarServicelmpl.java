package com.example.car.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.car.model.Car;
import com.example.car.repository.CarRepository;

@Service
public class CarServicelmpl implements CarService {

    @Autowired
    private CarRepository repository;

    public List<Car> getAllCars() {
        return repository.findAll();
    }

    public Car getCarById(int id) {
        return repository.findById(id);
    }

    public void deleteCarsByPriceRange(double min, double max) {
        repository.deleteByPriceRange(min, max);
    }

    public List<Car> getCarsByMakeAndYear(String make, int year) {
        return repository.findByMakeAndYear(make, year);
    }

    public Car updateCarByMake(String make, Car car) {
        return repository.updateByMake(make, car);
    }

    public void addCar(Car car) {
        repository.save(car);
    }
}

