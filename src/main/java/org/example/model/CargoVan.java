package org.example.model;

import org.example.service.CargoVanCostCalculator;
import org.example.service.VehicleCostCalculator;

public class CargoVan extends Vehicle {
    private double drivingExperience;

    public CargoVan(String brand, String model, double value, double driverExperience) {
        super(brand, model, value);
        this.drivingExperience = driverExperience;
    }

    public double getDriverExperience() {
        return drivingExperience;
    }

    public void setDriverExperience(double driverExperience) {
        this.drivingExperience = driverExperience;
    }

    @Override
    public double getInsuranceRate() {
        return 0.03;
    }

    @Override
    public double getRentalCostPerDay() {
        return 50.0;
    }

    @Override
    public double getDiscountRentalCostPerDay() {
        return 40.0;
    }

    @Override
    public VehicleCostCalculator getVehicleCostCalculator() {
        return new CargoVanCostCalculator();
    }

    @Override
    public String getVehicleInformation() {
        return String.format("A cargo van valued at %.2f, and the driver has %f years of experience", getValue(), getDriverExperience());
    }
}
