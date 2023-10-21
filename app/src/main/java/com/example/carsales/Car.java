package com.example.carsales;

public class Car {
    private int image;
    private String brand;
    private String model;
    private int year;
    private String description;
    private String cost;

    public Car(int image, String brand, String model, int year, String description, String cost) {
        this.image = image;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.description = description;
        this.cost = cost;
    }

    public int getImage() {
        return image;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getDescription() {
        return description;
    }

    public String getCost() {
        return cost;
    }
}

