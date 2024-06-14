package org.example.service;

import org.example.model.Car;
import org.example.model.Customer;
import org.example.model.Vehicle;

public class CarCostCalculator implements VehicleCostCalculator {

    @Override
    public double calculateInitialInsurancePerDay(Vehicle vehicle) {
        return (vehicle.getInsuranceRate() / 100) * vehicle.getValue();
    }

    @Override
    public double calculateFinalInsurancePerDay(Vehicle vehicle, Customer customer) {
        Car car = (Car) vehicle;
        double initialInsurance = calculateInitialInsurancePerDay(vehicle);
        double discount = car.getSafetyRating() >= 4 ? initialInsurance * 0.1 : 0.0;
        return initialInsurance - discount;
    }

    @Override
    public double calculateRentalCostPerDay(long rentalDays, Vehicle vehicle) {
        return rentalDays > 7 ? vehicle.getDiscountRentalCostPerDay() : vehicle.getRentalCostPerDay();
    }
}
