package com.example.car.service;


import java.util.List;
import com.example.car.model.Car;

public interface CarService {

    List<Car> getAllCars();
    Car getCarById(int id);
    void deleteCarsByPriceRange(double min, double max);
    List<Car> getCarsByMakeAndYear(String make, int year);
    Car updateCarByMake(String make, Car car);
    void addCar(Car car);
}
