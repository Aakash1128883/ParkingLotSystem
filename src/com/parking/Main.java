package com.parking;

import com.parking.cli.*;
import com.parking.repository.*;
import com.parking.service.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);   // the only Scanner in the whole app

        ParkingSlotRepository slotRepository = new ParkingSlotRepository();
        ParkingTicketRepository ticketRepository = new ParkingTicketRepository();
        PaymentRepository paymentRepository = new PaymentRepository();

        ParkingService parkingService = new ParkingService(slotRepository, ticketRepository);
        BillingService billingService = new BillingService();
        PaymentService paymentService = new PaymentService(paymentRepository, parkingService);

        PaymentCli paymentCli = new PaymentCli(scanner, paymentService);
        MainMenuCli menu = new MainMenuCli(scanner,
                new ParkingSlotCli(parkingService),
                new VehicleEntryCli(scanner, parkingService),
                new VehicleExitCli(scanner, parkingService, billingService, paymentCli),
                new ParkedVehicleCli(parkingService),
                new PaymentHistoryCli(paymentService));
        menu.start();
        scanner.close();
    }
}
