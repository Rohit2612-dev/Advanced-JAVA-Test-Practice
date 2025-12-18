package com.example.car.model;

public class Car {

    private int id;
    private String make;
    private String model;
    private double price;
    private int year;

    public Car() {}

    public Car(int id, String make, String model, double price, int year) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.price = price;
        this.year = year;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getMake() { return make; }
    public void setMake(String make) { this.make = make; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }
}
