package org.example.model;

import org.example.service.CarCostCalculator;
import org.example.service.MotorcycleCostCalculator;
import org.example.service.VehicleCostCalculator;

public class Motorcycle extends Vehicle {
    private int riderAge;

    public Motorcycle(String brand, String model, double value, int riderAge) {
        super(brand, model, value);
        this.riderAge = riderAge;
    }

    public int getRiderAge() {
        return riderAge;
    }

    public void setRiderAge(int riderAge) {
        this.riderAge = riderAge;
    }

    @Override
    public double getInsuranceRate() {
        return 0.02;
    }

    @Override
    public double getRentalCostPerDay() {
        return 15.0;
    }

    @Override
    public double getDiscountRentalCostPerDay() {
        return 10.0;
    }

    @Override
    public VehicleCostCalculator getVehicleCostCalculator() {
        return new MotorcycleCostCalculator();
    }

    @Override
    public String getVehicleInformation() {
        return String.format("A motorcycle valued at %.2f, and the driver is %d years old", getValue(), getRiderAge());
    }
}
