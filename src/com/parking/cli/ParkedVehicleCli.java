package com.parking.cli;

import com.parking.model.ParkingTicket;
import com.parking.service.ParkingService;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ParkedVehicleCli {
    private ParkingService parkingService;

    public ParkedVehicleCli(ParkingService parkingService) {
        this.parkingService = parkingService;
    }

    public void show() {
        System.out.println("\n--- Parked Vehicles ---");
        ArrayList<ParkingTicket> tickets = parkingService.getActiveTickets();
        if (tickets.isEmpty()) {
            System.out.println("No vehicles are parked now.");
            return;
        }
        System.out.printf("%-8s %-12s %-12s %-8s %-6s %-20s%n",
                "Ticket", "Vehicle No", "Owner", "Type", "Slot", "Entry Time");
        for (ParkingTicket t : tickets) {
            System.out.printf("%-8s %-12s %-12s %-8s %-6s %-20s%n",
                    t.getTicketId(), t.getVehicle().getRegistrationNumber(), t.getVehicle().getOwnerName(),
                    t.getVehicle().getVehicleType(), t.getSlot().getSlotId(),
                    t.getEntryTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
        }
    }
}
