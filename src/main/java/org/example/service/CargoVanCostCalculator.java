package org.example.service;

import org.example.model.CargoVan;
import org.example.model.Customer;
import org.example.model.Vehicle;

public class CargoVanCostCalculator implements VehicleCostCalculator {
    @Override
    public double calculateInitialInsurancePerDay(Vehicle vehicle) {
        return (vehicle.getInsuranceRate() / 100) * vehicle.getValue();
    }

    @Override
    public double calculateFinalInsurancePerDay(Vehicle vehicle, Customer customer) {
        CargoVan cargoVan = (CargoVan) vehicle;
        double initialInsurance = calculateInitialInsurancePerDay(vehicle);
        double discount = cargoVan.getDriverExperience() >= 5 ? initialInsurance * 0.15 : 0.0;
        return initialInsurance - discount;
    }

    @Override
    public double calculateRentalCostPerDay(long rentalDays, Vehicle vehicle) {
        return rentalDays > 7 ? vehicle.getDiscountRentalCostPerDay() : vehicle.getRentalCostPerDay();
    }
}
