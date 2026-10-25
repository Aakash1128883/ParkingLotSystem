package com.parking.model;

public class Car extends Vehicle {
    public Car(String registrationNumber, String ownerName) {
        super(registrationNumber, ownerName);
    }

    @Override
    public String getVehicleType() { return "CAR"; }

    @Override
    public int getHourlyRate() { return 20; }
}
