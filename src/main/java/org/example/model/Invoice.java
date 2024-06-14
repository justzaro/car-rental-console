package org.example.model;

import java.time.LocalDate;
import java.util.Optional;

public class Invoice {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private long reservedRentalDays;
    private LocalDate returnDate;
    private long actualRentalDays;
    private double rentalCostPerDay;
    private double initialInsurancePerDay;
    private Optional<Double> insuranceAdditionPerDay;
    private Optional<Double> insuranceDiscountPerDay;
    private double finalInsurancePerDay;
    private Optional<Double> earlyReturnDiscountForRent;
    private Optional<Double> earlyReturnDiscountForInsurance;
    private double totalRent;
    private double totalInsurance;
    private double total;
    public Invoice(Customer customer, Vehicle vehicle, LocalDate reservationStartDate,
                   LocalDate reservationEndDate, long reservedRentalDays, LocalDate returnDate,
                   long actualRentalDays, double rentalCostPerDay, double initialInsurancePerDay,
                   Double insuranceAdditionPerDay, Double insuranceDiscountPerDay,
                   double finalInsurancePerDay, Double earlyReturnDiscountForRent,
                   Double earlyReturnDiscountForInsurance, double totalRent, double totalInsurance,
                   double total) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.reservedRentalDays = reservedRentalDays;
        this.returnDate = returnDate;
        this.actualRentalDays = actualRentalDays;
        this.rentalCostPerDay = rentalCostPerDay;
        this.initialInsurancePerDay = initialInsurancePerDay;
        this.insuranceAdditionPerDay = Optional.ofNullable(insuranceAdditionPerDay);
        this.insuranceDiscountPerDay = Optional.ofNullable(insuranceDiscountPerDay);
        this.finalInsurancePerDay = finalInsurancePerDay;
        this.earlyReturnDiscountForRent = Optional.ofNullable(earlyReturnDiscountForRent);
        this.earlyReturnDiscountForInsurance = Optional.ofNullable(earlyReturnDiscountForInsurance);
        this.totalRent = totalRent;
        this.totalInsurance = totalInsurance;
        this.total = total;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public long getReservedRentalDays() {
        return reservedRentalDays;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public long getActualRentalDays() {
        return actualRentalDays;
    }

    public double getRentalCostPerDay() {
        return rentalCostPerDay;
    }

    public double getInitialInsurancePerDay() {
        return initialInsurancePerDay;
    }

    public Optional<Double> getInsuranceAdditionPerDay() {
        return insuranceAdditionPerDay;
    }

    public Optional<Double> getInsuranceDiscountPerDay() {
        return insuranceDiscountPerDay;
    }

    public double getFinalInsurancePerDay() {
        return finalInsurancePerDay;
    }

    public Optional<Double> getEarlyReturnDiscountForRent() {
        return earlyReturnDiscountForRent;
    }

    public Optional<Double> getEarlyReturnDiscountForInsurance() {
        return earlyReturnDiscountForInsurance;
    }

    public double getTotalRent() {
        return totalRent;
    }

    public double getTotalInsurance() {
        return totalInsurance;
    }

    public double getTotal() {
        return total;
    }
}
