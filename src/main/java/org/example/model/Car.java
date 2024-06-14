package org.example.model;

import org.example.service.CarCostCalculator;
import org.example.service.VehicleCostCalculator;

public class Car extends Vehicle {
    private int safetyRating;

    public Car(String brand, String model, double value, int safetyRating) {
        super(brand, model, value);
        this.safetyRating = safetyRating;
    }

    public int getSafetyRating() {
        return safetyRating;
    }

    public void setSafetyRating(int safetyRating) {
        this.safetyRating = safetyRating;
    }

    @Override
    public double getInsuranceRate() {
        return 0.01;
    }

    @Override
    public double getRentalCostPerDay() {
        return 20.0;
    }

    @Override
    public double getDiscountRentalCostPerDay() {
        return 15.0;
    }

    @Override
    public VehicleCostCalculator getVehicleCostCalculator() {
        return new CarCostCalculator();
    }

    @Override
    public String getVehicleInformation() {
        return String.format("A car valued at %.2f, and the security rating is %d", getValue(), getSafetyRating());
    }
}
