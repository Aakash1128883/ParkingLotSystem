package com.parking.cli;

import com.parking.model.ParkingBill;
import com.parking.model.ParkingTicket;
import com.parking.service.BillingService;
import com.parking.service.ParkingService;
import java.time.LocalDateTime;
import java.util.Scanner;

public class VehicleExitCli {
    private Scanner scanner;
    private ParkingService parkingService;
    private BillingService billingService;
    private PaymentCli paymentCli;

    public VehicleExitCli(Scanner scanner, ParkingService parkingService,
                          BillingService billingService, PaymentCli paymentCli) {
        this.scanner = scanner;
        this.parkingService = parkingService;
        this.billingService = billingService;
        this.paymentCli = paymentCli;
    }

    public void exitVehicle() {
        System.out.println("\n--- Exit Vehicle and Pay Bill ---");
        System.out.print("Registration number: ");
        String regNo = scanner.nextLine().trim();

        ParkingTicket ticket = parkingService.findActiveTicket(regNo);
        if (ticket == null) {
            System.out.println("No active parking ticket found for this vehicle.");
            return;
        }

        ParkingBill bill = billingService.calculateBill(ticket, LocalDateTime.now());

        System.out.println("\n----- PARKING BILL -----");
        System.out.println("Ticket ID       : " + bill.getTicketId());
        System.out.println("Vehicle number  : " + bill.getVehicleNumber());
        System.out.println("Parking slot    : " + bill.getSlotId());
        System.out.println("Duration        : " + (bill.getDurationMinutes() / 60) + " hr "
                + (bill.getDurationMinutes() % 60) + " min");
        System.out.println("Hourly rate     : ₹" + bill.getHourlyRate());
        System.out.println("Chargeable hours: " + bill.getChargeableHours());
        System.out.println("Total amount    : ₹" + bill.getTotalAmount());
        System.out.println("------------------------");

        paymentCli.start(ticket, bill);
    }
}
