package org.example.model;

import java.time.LocalDate;

public class VehicleRental {
    private Customer customer;
    private Vehicle vehicle;
    private LocalDate reservationStartDate;
    private LocalDate reservationEndDate;
    private LocalDate returnDate;

    public VehicleRental(Customer customer, Vehicle vehicle,
                         LocalDate reservationStartDate, LocalDate reservationEndDate,
                         LocalDate returnDate) {
        this.customer = customer;
        this.vehicle = vehicle;
        this.reservationStartDate = reservationStartDate;
        this.reservationEndDate = reservationEndDate;
        this.returnDate = returnDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public LocalDate getReservationStartDate() {
        return reservationStartDate;
    }

    public void setReservationStartDate(LocalDate reservationStartDate) {
        this.reservationStartDate = reservationStartDate;
    }

    public LocalDate getReservationEndDate() {
        return reservationEndDate;
    }

    public void setReservationEndDate(LocalDate reservationEndDate) {
        this.reservationEndDate = reservationEndDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
