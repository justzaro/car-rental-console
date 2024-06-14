package org.example;

import org.example.model.*;
import org.example.service.InvoicePrinter;
import org.example.service.RentalCalculator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Zahari",
                                         "Nikiforov",
                                         22);

//        Car car = new Car("BMW", "F10", 15000, 3);
//        VehicleRental request = new VehicleRental(
//                customer, car,
//                LocalDate.of(2024, 6, 3),
//                LocalDate.of(2024, 6, 13),
//                LocalDate.of(2024, 6, 13));

        Motorcycle motorcycle = new Motorcycle("Ducati", "Panigale V4S", 10000, 20);

//        VehicleRental request = new VehicleRental(
//                customer, motorcycle,
//                LocalDate.of(2024, 6, 3),
//                LocalDate.of(2024, 6, 13),
//                LocalDate.of(2024, 6, 13));

        CargoVan cargoVan = new CargoVan("Citroen", "Jumper", 20000, 8);

        VehicleRental request = new VehicleRental(
                customer, cargoVan,
                LocalDate.of(2024, 6, 3),
                LocalDate.of(2024, 6, 18),
                LocalDate.of(2024, 6, 13));

        RentalCalculator rentalCalculator = new RentalCalculator();
        Invoice invoice = rentalCalculator.createInvoice(request);
        InvoicePrinter invoicePrinter = new InvoicePrinter();
        invoicePrinter.printInvoice(invoice);
    }
}