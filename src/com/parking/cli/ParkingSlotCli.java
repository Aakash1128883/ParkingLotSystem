package com.parking.cli;

import com.parking.model.ParkingSlot;
import com.parking.service.ParkingService;

public class ParkingSlotCli {
    private ParkingService parkingService;

    public ParkingSlotCli(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void show() {
        System.out.println("\n--- Parking Slots ---");
        System.out.printf("%-8s %-8s %-10s%n", "Slot", "Type", "Status");
        for (ParkingSlot slot : parkingService.getAllSlots()) {
            System.out.printf("%-8s %-8s %-10s%n", slot.getSlotId(), slot.getSlotType(), slot.getStatus());
        }
    }
}
