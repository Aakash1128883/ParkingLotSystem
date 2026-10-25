package com.parking.cli;

import com.parking.model.Bike;
import com.parking.model.Car;
import com.parking.model.ParkingTicket;
import com.parking.model.Truck;
import com.parking.model.Vehicle;
import com.parking.service.ParkingService;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VehicleEntryCli {
    private Scanner scanner;
    private ParkingService parkingService;

    public VehicleEntryCli(Scanner scanner, ParkingService parkingService) {
        this.scanner = scanner;
        this.parkingService = parkingService;
    }

    public void park() {
        System.out.println("\n--- Park a Vehicle ---");
        System.out.print("Registration number: ");
        String regNo = scanner.nextLine().trim().toUpperCase();
        if (regNo.isEmpty()) {
            System.out.println("Registration number cannot be empty.");
            return;
        }
        if (parkingService.isVehicleParked(regNo)) {
            System.out.println("This vehicle is already parked.");
            return;
        }
        System.out.print("Owner name: ");
        String owner = scanner.nextLine().trim();
        System.out.println("Vehicle type: 1. Car  2. Bike  3. Truck");
        System.out.print("Choose type: ");
        String choice = scanner.nextLine().trim();

        Vehicle vehicle;
        switch (choice) {
            case "1": vehicle = new Car(regNo, owner); break;
            case "2": vehicle = new Bike(regNo, owner); break;
            case "3": vehicle = new Truck(regNo, owner); break;
            default:
                System.out.println("Invalid vehicle type.");
                return;
        }

        ParkingTicket ticket = parkingService.parkVehicle(vehicle);
        if (ticket == null) {
            System.out.println("Parking Full");
            return;
        }
        System.out.println("\nVehicle parked successfully!");
        System.out.println("Ticket ID  : " + ticket.getTicketId());
        System.out.println("Vehicle    : " + regNo + " (" + vehicle.getVehicleType() + ")");
        System.out.println("Slot       : " + ticket.getSlot().getSlotId());
        System.out.println("Entry time : "
                + ticket.getEntryTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }
}
