package com.parking.model;

public class Bike extends Vehicle {
    public Bike(String registrationNumber, String ownerName) {
        super(registrationNumber, ownerName);
    }

    @Override
    public String getVehicleType() { return "BIKE"; }

    @Override
    public int getHourlyRate() { return 10; }
}
