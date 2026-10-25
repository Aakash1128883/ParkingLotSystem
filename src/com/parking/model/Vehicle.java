package com.parking.model;

// Abstract parent class for all vehicles (Abstraction + Inheritance)
public abstract class Vehicle {
    private String registrationNumber;
    private String ownerName;

    public Vehicle(String registrationNumber, String ownerName) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
    }

    public String getRegistrationNumber() { return registrationNumber; }
    public String getOwnerName() { return ownerName; }

    // Each child class gives its own answer (Polymorphism)
    public abstract String getVehicleType();
    public abstract int getHourlyRate();
}
