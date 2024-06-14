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

    public String generateInvoice() {
        StringBuilder invoice = new StringBuilder();
        invoice.append(vehicle.getVehicleInformation()).append("\n");
        invoice.append("------------------------------------\n");
        invoice.append("Date: ").append(reservationStartDate).append("\n");
        invoice.append("Customer Name: ").append(customer.getFirstName()).append(" ").append(customer.getLastName()).append("\n");
        invoice.append("Rented Vehicle: ").append(vehicle.getBrand()).append(" ").append(vehicle.getModel()).append("\n");
        invoice.append("------------------------------------\n");
        invoice.append("Reservation start date: ").append(reservationStartDate).append("\n");
        invoice.append("Reservation end date: ").append(reservationEndDate).append("\n");
        invoice.append("Reserved rental days: ").append(reservedRentalDays).append("\n");
        invoice.append("------------------------------------\n");
        invoice.append("Actual return date: ").append(returnDate).append("\n");
        invoice.append("Actual rental days: ").append(actualRentalDays).append("\n");
        invoice.append("Rental cost per day: $").append(String.format("%.2f", rentalCostPerDay)).append("\n");

        insuranceAdditionPerDay.ifPresent(value -> {
            invoice.append("Initial insurance per day: $").append(String.format("%.2f", initialInsurancePerDay)).append("\n");
            invoice.append("Insurance addition per day: $").append(String.format("%.2f", value)).append("\n");
        });

        insuranceDiscountPerDay.ifPresent(value -> {
            invoice.append("Initial insurance per day: $").append(String.format("%.2f", initialInsurancePerDay)).append("\n");
            invoice.append("Insurance discount per day: $").append(String.format("%.2f", value)).append("\n");
        });

        invoice.append("Insurance per day: $").append(String.format("%.2f", finalInsurancePerDay)).append("\n");

        earlyReturnDiscountForRent.ifPresent(value -> {
            invoice.append("Early return discount for rent: $").append(String.format("%.2f", value)).append("\n");
        });

        earlyReturnDiscountForInsurance.ifPresent(value -> {
            invoice.append("Early return discount for insurance: $").append(String.format("%.2f", value)).append("\n");
        });

        invoice.append("------------------------\n");
        invoice.append("Total rent: $").append(String.format("%.2f", totalRent)).append("\n");
        invoice.append("Total insurance: $").append(String.format("%.2f", totalInsurance)).append("\n");
        invoice.append("Total: $").append(String.format("%.2f", total)).append("\n");

        return invoice.toString();
    }
}
