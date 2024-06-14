package org.example.model;

import org.example.service.VehicleCostCalculator;

public abstract class Vehicle {
    private String brand;
    private String model;
    private double value;

    public Vehicle(String brand, String model, double value) {
        this.brand = brand;
        this.model = model;
        this.value = value;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public abstract double getInsuranceRate();
    public abstract double getRentalCostPerDay();
    public abstract double getDiscountRentalCostPerDay();
    public abstract String getVehicleInformation();
    public abstract VehicleCostCalculator getVehicleCostCalculator();

}
