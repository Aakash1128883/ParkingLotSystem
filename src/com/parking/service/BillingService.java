package com.parking.service;

import com.parking.model.ParkingBill;
import com.parking.model.ParkingTicket;
import java.time.Duration;
import java.time.LocalDateTime;

public class BillingService {

    public ParkingBill calculateBill(ParkingTicket ticket, LocalDateTime exitTime) {
        long minutes = Duration.between(ticket.getEntryTime(), exitTime).toMinutes();
        // Rate depends on the VEHICLE, so a Bike in a Car slot still pays the Bike rate
        int rate = ticket.getVehicle().getHourlyRate();
        int maxPerDay = rate * 8;

        long chargeableHours = 0;
        int total = 0;

        if (minutes > 15) {                              // first 15 minutes are free
            chargeableHours = (minutes + 59) / 60;       // round up to the next full hour
            long fullDays = minutes / 1440;              // complete 24-hour periods
            long leftoverMinutes = minutes % 1440;
            long leftoverHours = (leftoverMinutes + 59) / 60;
            long leftoverCharge = leftoverHours * rate;
            if (leftoverCharge > maxPerDay) {            // cap per 24-hour period
                leftoverCharge = maxPerDay;
            }
            total = (int) (fullDays * maxPerDay + leftoverCharge);
        }

        return new ParkingBill(ticket.getTicketId(),
                ticket.getVehicle().getRegistrationNumber(),
                ticket.getSlot().getSlotId(),
                exitTime, minutes, rate, chargeableHours, total);
    }
}
