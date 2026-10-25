package com.parking.model;

import java.time.LocalDateTime;

public class ParkingBill {
    private String ticketId;
    private String vehicleNumber;
    private String slotId;
    private LocalDateTime exitTime;
    private long durationMinutes;
    private int hourlyRate;
    private long chargeableHours;
    private int totalAmount;

    public ParkingBill(String ticketId, String vehicleNumber, String slotId, LocalDateTime exitTime,
                       long durationMinutes, int hourlyRate, long chargeableHours, int totalAmount) {
        this.ticketId = ticketId;
        this.vehicleNumber = vehicleNumber;
        this.slotId = slotId;
        this.exitTime = exitTime;
        this.durationMinutes = durationMinutes;
        this.hourlyRate = hourlyRate;
        this.chargeableHours = chargeableHours;
        this.totalAmount = totalAmount;
    }

    public String getTicketId() { return ticketId; }
    public String getVehicleNumber() { return vehicleNumber; }
    public String getSlotId() { return slotId; }
    public LocalDateTime getExitTime() { return exitTime; }
    public long getDurationMinutes() { return durationMinutes; }
    public int getHourlyRate() { return hourlyRate; }
    public long getChargeableHours() { return chargeableHours; }
    public int getTotalAmount() { return totalAmount; }
}
