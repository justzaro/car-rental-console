package org.example.service;

import org.example.model.Invoice;

public class InvoicePrinter {
    public void printInvoice(Invoice invoice) {
        System.out.printf("%s%n", invoice.getVehicle().getVehicleInformation());
        System.out.println("------------------------------------");
        System.out.printf("Date: %s%n", invoice.getReservationStartDate());
        System.out.printf("Customer Name: %s %s%n", invoice.getCustomer().getFirstName(), invoice.getCustomer().getLastName());
        System.out.printf("Rented Vehicle: %s %s%n", invoice.getVehicle().getBrand(), invoice.getVehicle().getModel());
        System.out.println("------------------------------------");
        System.out.printf("Reservation start date: %s%n", invoice.getReservationStartDate());
        System.out.printf("Reservation end date: %s%n", invoice.getReservationEndDate());
        System.out.printf("Reserved rental days: %d%n", invoice.getReservedRentalDays());
        System.out.println("------------------------------------");
        System.out.printf("Actual return date: %s%n", invoice.getReturnDate());
        System.out.printf("Actual rental days: %d%n", invoice.getActualRentalDays());
        System.out.printf("Rental cost per day: $%.2f%n", invoice.getRentalCostPerDay());

        invoice.getInsuranceAdditionPerDay().ifPresent(value -> {
            System.out.printf("Initial insurance per day: $%.2f%n", invoice.getInitialInsurancePerDay());
            System.out.printf("Insurance addition per day: $%.2f%n", value);
        });

        invoice.getInsuranceDiscountPerDay().ifPresent(value -> {
            System.out.printf("Initial insurance per day: $%.2f%n", invoice.getInitialInsurancePerDay());
            System.out.printf("Insurance discount per day: $%.2f%n", value);
        });

        System.out.printf("Insurance per day: $%.2f%n", invoice.getFinalInsurancePerDay());

        invoice.getEarlyReturnDiscountForRent().ifPresent(value -> {
            System.out.printf("Early return discount for rent: $%.2f%n", value);
        });

        invoice.getEarlyReturnDiscountForInsurance().ifPresent(value -> {
            System.out.printf("Early return discount for insurance: $%.2f%n", value);
        });

        System.out.println("------------------------");
        System.out.printf("Total rent: $%.2f%n", invoice.getTotalRent());
        System.out.printf("Total insurance: $%.2f%n", invoice.getTotalInsurance());
        System.out.printf("Total: $%.2f%n", invoice.getTotal());

    }
}
