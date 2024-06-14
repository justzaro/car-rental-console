package org.example.service;

import org.example.model.*;

import java.time.temporal.ChronoUnit;

public class RentalCalculator {
    public Invoice createInvoice(VehicleRental rental) {
        Vehicle vehicle = rental.getVehicle();
        Customer customer = rental.getCustomer();

        long rentalDays = rental.getReservationStartDate().until(rental.getReservationEndDate(), ChronoUnit.DAYS);
        long actualRentalDays = rental.getReservationStartDate().until(rental.getReturnDate(), ChronoUnit.DAYS);

        VehicleCostCalculator vehicleCostCalculator = vehicle.getVehicleCostCalculator();

        double dailyRentalCost = vehicleCostCalculator.calculateRentalCostPerDay(rentalDays, vehicle);
        double initialInsurancePerDay = vehicleCostCalculator.calculateInitialInsurancePerDay(vehicle);
        double finalInsurancePerDay = vehicleCostCalculator.calculateFinalInsurancePerDay(vehicle, customer);

        Double insuranceAdditionPerDay = null;
        Double insuranceDiscountPerDay = null;

        if (initialInsurancePerDay != finalInsurancePerDay) {
            if (finalInsurancePerDay < initialInsurancePerDay) {
                insuranceDiscountPerDay = initialInsurancePerDay - finalInsurancePerDay;
            } else {
                insuranceAdditionPerDay = finalInsurancePerDay - initialInsurancePerDay;
            }
        }

        double totalRentalCost = dailyRentalCost * rentalDays;
        double totalInsuranceCost = finalInsurancePerDay * rentalDays;

        Double earlyReturnRentDiscount = null;
        Double earlyReturnInsuranceDiscount = null;

        if (actualRentalDays < rentalDays) {
            long remainingDays = rentalDays - actualRentalDays;
            earlyReturnRentDiscount = totalRentalCost - ((dailyRentalCost * actualRentalDays) + ((dailyRentalCost / 2) * remainingDays));
            earlyReturnInsuranceDiscount = totalInsuranceCost - (finalInsurancePerDay * actualRentalDays);

            totalRentalCost -= earlyReturnRentDiscount;
            totalInsuranceCost -= earlyReturnInsuranceDiscount;
        }

        Invoice invoice = new ConcreteInvoiceBuilder()
                .customer(customer)
                .vehicle(vehicle)
                .reservationStartDate(rental.getReservationStartDate())
                .reservationEndDate(rental.getReservationEndDate())
                .reservedRentalDays(rentalDays)
                .returnDate(rental.getReturnDate())
                .actualRentalDays(actualRentalDays)
                .rentalCostPerDay(dailyRentalCost)
                .initialInsurancePerDay(initialInsurancePerDay)
                .insuranceAdditionPerDay(insuranceAdditionPerDay)
                .insuranceDiscountPerDay(insuranceDiscountPerDay)
                .finalInsurancePerDay(finalInsurancePerDay)
                .earlyReturnDiscountForRent(earlyReturnRentDiscount)
                .earlyReturnDiscountForInsurance(earlyReturnInsuranceDiscount)
                .totalRent(totalRentalCost)
                .totalInsurance(totalInsuranceCost)
                .total(totalRentalCost + totalInsuranceCost)
                .build();

        return invoice;
    }
}
