package org.example.model;

import java.time.LocalDate;

public interface InvoiceBuilder {
    InvoiceBuilder customer(Customer customer);
    InvoiceBuilder vehicle(Vehicle vehicle);
    InvoiceBuilder reservationStartDate(LocalDate reservationStartDate);
    InvoiceBuilder reservationEndDate(LocalDate reservationEndDate);
    InvoiceBuilder reservedRentalDays(long reservedRentalDays);
    InvoiceBuilder returnDate(LocalDate returnDate);
    InvoiceBuilder actualRentalDays(long actualRentalDays);
    InvoiceBuilder rentalCostPerDay(double rentalCostPerDay);
    InvoiceBuilder initialInsurancePerDay(double initialInsurancePerDay);
    InvoiceBuilder insuranceAdditionPerDay(Double insuranceAdditionPerDay);
    InvoiceBuilder insuranceDiscountPerDay(Double insuranceDiscountPerDay);
    InvoiceBuilder finalInsurancePerDay(double finalInsurancePerDay);
    InvoiceBuilder earlyReturnDiscountForRent(Double earlyReturnDiscountForRent);
    InvoiceBuilder earlyReturnDiscountForInsurance(Double earlyReturnDiscountForInsurance);
    InvoiceBuilder totalRent(double totalRent);
    InvoiceBuilder totalInsurance(double totalInsurance);
    InvoiceBuilder total(double total);
    Invoice build();
}