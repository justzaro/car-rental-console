package org.example.service;

import org.example.model.Customer;
import org.example.model.Vehicle;

public interface VehicleCostCalculator {
    double calculateInitialInsurancePerDay(Vehicle vehicle);
    double calculateFinalInsurancePerDay(Vehicle vehicle, Customer customer);
    double calculateRentalCostPerDay(long rentalDays, Vehicle vehicle);
}
