# Rental Management System

A system for managing vehicle rentals, calculating costs, and generating detailed invoices.

## Table of Contents

- [Overview](#overview)
- [Project Structure](#project-structure)
- [Approach](#approach)

## Overview

The Rental Management System handles vehicle rental operations, including customer management, reservation handling, cost calculation, and invoice generation. It's designed to be modular, allowing easy integration of new vehicle types and cost calculation strategies.

## Project Structure

### Model Package

- **Car**: Represents a car with car-specific safety-rating attribute.
- **CargoVan**: Represents a cargo-van with driver's driving experience attribute.
- **Motorcycle**: Represents a motorcycle with driver's age attribute.
- **Customer**: Holds customer details such as names and age.
- **Vehicle**: Abstract class providing common attributes and methods for vehicles.
- **Invoice**: Generates invoices based on rental details and costs.
- **VehicleRental**: Manages rental reservations including customer, vehicle, and dates.
- **ConcreteInvoiceBuilder**: Delegates methods to construct detailed invoices.

### Service Package

- **CarCostCalculator**: Calculates insurance and rental costs for cars.
- **CargoVanCostCalculator**: Calculates insurance and rental costs for cargo vans.
- **MotorcycleCostCalculator**: Calculates insurance and rental costs for motorcycles.
- **VehicleCostCalculator**: Interface for calculating insurance and rental costs.

## Approach
- Implementing Vehicle as an abstract class allows all subclasses to inherit the common fields and methods, define their specific rental and insurance costs per day and produce an object-specific cost calculator.
- This approach allows the VehicleRental to hold the abstract class Vehicle, and when used later in the RentalCalculator to calculate generata an invoice, it gives teh flexibility to work with the vehicle-specific cost calculator and costs instead of checking the type of vehicle and applying the costs manually.
- If a new vehicle is added in the future, it won't change the RentalCalculator logic, as it would have happened if the vehicle-specific costs were applied based of instanceof check, for example.
- The invoice is built using the builder pattern, which makes building the invoice easier and if a different invoice structure is needed, the ConcreteInvoiceBuilder can easily be replaced with a different one, who impelemnts the InvoiceBuilder interface.
- A invoice priner class is responisble for printing the invoices.
