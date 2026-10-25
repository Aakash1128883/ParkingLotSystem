package com.parking.model;

public class ParkingSlot {
    private String slotId;
    private String slotType;   // CAR, BIKE or TRUCK
    private String status;     // FREE or OCCUPIED

    public ParkingSlot(String slotId, String slotType) {
        this.slotId = slotId;
        this.slotType = slotType;
        this.status = "FREE";
    }

    public String getSlotId() { return slotId; }
    public String getSlotType() { return slotType; }
    public String getStatus() { return status; }
    public boolean isFree() { return status.equals("FREE"); }
    public void occupy() { status = "OCCUPIED"; }
    public void free() { status = "FREE"; }
}
