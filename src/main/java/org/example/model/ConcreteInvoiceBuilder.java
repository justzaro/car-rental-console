package org.example.model;

import java.time.LocalDate;

public class ConcreteInvoiceBuilder implements InvoiceBuilder {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private long reservedRentalDays;
    private LocalDate returnDate;
    private long actualRentalDays;
    private double rentalCostPerDay;
    private double initialInsurancePerDay;
    private Double insuranceAdditionPerDay;
    private Double insuranceDiscountPerDay;
    private double finalInsurancePerDay;
    private Double earlyReturnDiscountForRent;
    private Double earlyReturnDiscountForInsurance;
    private double totalRent;
    private double totalInsurance;
    private double total;

    @Override
    public InvoiceBuilder customer(Customer customer) {
        this.customer = customer;
        return this;
    }

    @Override
    public InvoiceBuilder vehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    @Override
    public InvoiceBuilder reservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
        return this;
    }

    @Override
    public InvoiceBuilder reservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
        return this;
    }

    @Override
    public InvoiceBuilder reservedRentalDays(long reservedRentalDays) {
        this.reservedRentalDays = reservedRentalDays;
        return this;
    }

    @Override
    public InvoiceBuilder returnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }

    @Override
    public InvoiceBuilder actualRentalDays(long actualRentalDays) {
        this.actualRentalDays = actualRentalDays;
        return this;
    }

    @Override
    public InvoiceBuilder rentalCostPerDay(double rentalCostPerDay) {
        this.rentalCostPerDay = rentalCostPerDay;
        return this;
    }

    @Override
    public InvoiceBuilder initialInsurancePerDay(double initialInsurancePerDay) {
        this.initialInsurancePerDay = initialInsurancePerDay;
        return this;
    }

    @Override
    public InvoiceBuilder insuranceAdditionPerDay(Double insuranceAdditionPerDay) {
        this.insuranceAdditionPerDay = insuranceAdditionPerDay;
        return this;
    }

    @Override
    public InvoiceBuilder insuranceDiscountPerDay(Double insuranceDiscountPerDay) {
        this.insuranceDiscountPerDay = insuranceDiscountPerDay;
        return this;
    }

    @Override
    public InvoiceBuilder finalInsurancePerDay(double finalInsurancePerDay) {
        this.finalInsurancePerDay = finalInsurancePerDay;
        return this;
    }

    @Override
    public InvoiceBuilder earlyReturnDiscountForRent(Double earlyReturnDiscountForRent) {
        this.earlyReturnDiscountForRent = earlyReturnDiscountForRent;
        return this;
    }

    @Override
    public InvoiceBuilder earlyReturnDiscountForInsurance(Double earlyReturnDiscountForInsurance) {
        this.earlyReturnDiscountForInsurance = earlyReturnDiscountForInsurance;
        return this;
    }

    @Override
    public InvoiceBuilder totalRent(double totalRent) {
        this.totalRent = totalRent;
        return this;
    }

    @Override
    public InvoiceBuilder totalInsurance(double totalInsurance) {
        this.totalInsurance = totalInsurance;
        return this;
    }

    @Override
    public InvoiceBuilder total(double total) {
        this.total = total;
        return this;
    }

    @Override
    public Invoice build() {
        return new Invoice(customer, vehicle, reservationStartDate, reservationEndDate,
                reservedRentalDays, returnDate, actualRentalDays, rentalCostPerDay,
                initialInsurancePerDay, insuranceAdditionPerDay, insuranceDiscountPerDay,
                finalInsurancePerDay, earlyReturnDiscountForRent, earlyReturnDiscountForInsurance,
                totalRent, totalInsurance, total);
    }
}