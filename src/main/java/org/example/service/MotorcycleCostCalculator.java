package org.example.service;

import org.example.model.Customer;
import org.example.model.Motorcycle;
import org.example.model.Vehicle;

public class MotorcycleCostCalculator implements VehicleCostCalculator {
    @Override
    public double calculateInitialInsurancePerDay(Vehicle vehicle) {
        return (vehicle.getInsuranceRate() / 100) * vehicle.getValue();
    }

    @Override
    public double calculateFinalInsurancePerDay(Vehicle vehicle, Customer customer) {
        Motorcycle motorcycle = (Motorcycle) vehicle;
        double initialInsurance = calculateInitialInsurancePerDay(vehicle);
        double addition = motorcycle.getRiderAge() < 25 ? initialInsurance * 0.2 : 0.0;
        return initialInsurance + addition;
    }

    @Override
    public double calculateRentalCostPerDay(long rentalDays, Vehicle vehicle) {
        return rentalDays > 7 ? vehicle.getDiscountRentalCostPerDay() : vehicle.getRentalCostPerDay();
    }
}
