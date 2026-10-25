package com.parking.cli;

import com.parking.model.ParkingBill;
import com.parking.model.ParkingTicket;
import com.parking.model.Payment;
import com.parking.service.PaymentService;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class PaymentCli {
    private Scanner scanner;
    private PaymentService paymentService;

    public PaymentCli(Scanner scanner, PaymentService paymentService) {
        this.scanner = scanner;
        this.paymentService = paymentService;
    }

    public void start(ParkingTicket ticket, ParkingBill bill) {
        while (true) {
            System.out.println("\nPayment Method:");
            System.out.println("1. Cash");
            System.out.println("2. UPI");
            System.out.println("3. Card");
            System.out.println("0. Cancel Payment");
            System.out.print("Choose: ");
            String choice = scanner.nextLine().trim();

            String method;
            switch (choice) {
                case "1": method = "Cash"; break;
                case "2": method = "UPI"; break;
                case "3": method = "Card"; break;
                case "0":
                    System.out.println("Payment cancelled. Vehicle stays parked.");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
                    continue;
            }

            System.out.println("Simulate payment result: 1. Success  2. Fail");
            System.out.print("Choose: ");
            String result = scanner.nextLine().trim();
            if (!result.equals("1") && !result.equals("2")) {
                System.out.println("Invalid choice. Try again.");
                continue;
            }

            Payment payment = paymentService.processPayment(ticket, bill, method, result.equals("1"));
            printReceipt(payment);

            if (payment.getStatus().equals("PAID")) {
                System.out.println("Payment successful. Thank you! Slot is now FREE.");
                return;
            }
            System.out.println("Payment FAILED. Ticket is still active. You can retry or cancel.");
        }
    }

    private void printReceipt(Payment payment) {
        System.out.println("\n======== RECEIPT ========");
        System.out.println("Receipt ID   : " + payment.getReceiptId());
        System.out.println("Payment ID   : " + payment.getPaymentId());
        System.out.println("Ticket ID    : " + payment.getTicketId());
        System.out.println("Amount       : ₹" + payment.getAmount());
        System.out.println("Method       : " + payment.getMethod());
        System.out.println("Time         : "
                + payment.getPaymentTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        System.out.println("Status       : " + payment.getStatus());
        System.out.println("=========================");
    }
}
