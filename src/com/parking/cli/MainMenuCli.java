package com.parking.cli;

import java.util.Scanner;

public class MainMenuCli {
    private Scanner scanner;
    private ParkingSlotCli slotCli;
    private VehicleEntryCli entryCli;
    private VehicleExitCli exitCli;
    private ParkedVehicleCli parkedCli;
    private PaymentHistoryCli historyCli;

    public MainMenuCli(Scanner scanner, ParkingSlotCli slotCli, VehicleEntryCli entryCli,
                       VehicleExitCli exitCli, ParkedVehicleCli parkedCli, PaymentHistoryCli historyCli) {
        this.scanner = scanner;
        this.slotCli = slotCli;
        this.entryCli = entryCli;
        this.exitCli = exitCli;
        this.parkedCli = parkedCli;
        this.historyCli = historyCli;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n===== PARKING LOT SYSTEM =====");
            System.out.println("1. View Parking Slots");
            System.out.println("2. Park a Vehicle");
            System.out.println("3. Exit Vehicle and Pay Bill");
            System.out.println("4. View Parked Vehicles");
            System.out.println("5. View Payment History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            String choice = scanner.hasNextLine() ? scanner.nextLine().trim() : "0";

            switch (choice) {
                case "1": slotCli.show(); break;
                case "2": entryCli.park(); break;
                case "3": exitCli.exitVehicle(); break;
                case "4": parkedCli.show(); break;
                case "5": historyCli.show(); break;
                case "0":
                    System.out.println("Thank you! Goodbye.");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
