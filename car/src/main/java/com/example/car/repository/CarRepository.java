package com.example.car.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;
import com.example.car.model.Car;

@Repository
public class CarRepository {

    private List<Car> cars = new ArrayList<>();

    public CarRepository() {
        cars.add(new Car(1, "Honda", "City", 800000, 2020));
        cars.add(new Car(2, "Maruti", "Swift", 600000, 2019));
        cars.add(new Car(3, "Hyundai", "Verna", 900000, 2021));
        cars.add(new Car(4, "Honda", "Amaze", 700000, 2020));
        cars.add(new Car(5, "Tata", "Nexon", 950000, 2022));
    }

    public List<Car> findAll() {
        return cars;
    }

    public Car findById(int id) {
        return cars.stream()
                   .filter(c -> c.getId() == id)
                   .findFirst()
                   .orElse(null);
    }

    public void save(Car car) {
        cars.add(car);
    }

    public void deleteByPriceRange(double min, double max) {
        cars.removeIf(c -> c.getPrice() >= min && c.getPrice() <= max);
    }

    public List<Car> findByMakeAndYear(String make, int year) {
        return cars.stream()
                   .filter(c -> c.getMake().equalsIgnoreCase(make)
                             && c.getYear() == year)
                   .collect(Collectors.toList());
    }

    public Car updateByMake(String make, Car updatedCar) {
        for (Car c : cars) {
            if (c.getMake().equalsIgnoreCase(make)) {
                c.setModel(updatedCar.getModel());
                c.setPrice(updatedCar.getPrice());
                c.setYear(updatedCar.getYear());
                return c;
            }
        }
        return null;
    }
}
