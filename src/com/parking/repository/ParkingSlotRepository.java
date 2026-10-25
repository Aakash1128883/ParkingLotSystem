package com.parking.repository;

import com.parking.model.ParkingSlot;
import java.util.ArrayList;

public class ParkingSlotRepository {
    private ArrayList<ParkingSlot> slots = new ArrayList<>();

    // A few slots are created when the program starts
    public ParkingSlotRepository() {
        slots.add(new ParkingSlot("B1", "BIKE"));
        slots.add(new ParkingSlot("B2", "BIKE"));
        slots.add(new ParkingSlot("C1", "CAR"));
        slots.add(new ParkingSlot("C2", "CAR"));
        slots.add(new ParkingSlot("C3", "CAR"));
        slots.add(new ParkingSlot("T1", "TRUCK"));
    }

    public ArrayList<ParkingSlot> getAllSlots() { return slots; }

    public ParkingSlot findFirstFreeSlot(String slotType) {
        for (ParkingSlot slot : slots) {
            if (slot.getSlotType().equals(slotType) && slot.isFree()) {
                return slot;
            }
        }
        return null;
    }
}
