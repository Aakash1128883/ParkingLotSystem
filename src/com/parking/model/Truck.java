package com.parking.model;

public class Truck extends Vehicle {
    public Truck(String registrationNumber, String ownerName) {
        super(registrationNumber, ownerName);
    }

    @Override
    public String getVehicleType() { return "TRUCK"; }

    @Override
    public int getHourlyRate() { return 40; }
}
