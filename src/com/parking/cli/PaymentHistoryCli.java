package com.parking.cli;

import com.parking.model.Payment;
import com.parking.service.PaymentService;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PaymentHistoryCli {
    private PaymentService paymentService;

    public PaymentHistoryCli(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public void show() {
        System.out.println("\n--- Payment History ---");
        ArrayList<Payment> payments = paymentService.getAllPayments();
        if (payments.isEmpty()) {
            System.out.println("No payments yet.");
            return;
        }
        System.out.printf("%-8s %-8s %-8s %-8s %-8s %-18s %-8s%n",
                "Payment", "Receipt", "Ticket", "Amount", "Method", "Time", "Status");
        for (Payment p : payments) {
            System.out.printf("%-8s %-8s %-8s ₹%-7d %-8s %-18s %-8s%n",
                    p.getPaymentId(), p.getReceiptId(), p.getTicketId(), p.getAmount(), p.getMethod(),
                    p.getPaymentTime().format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss")),
                    p.getStatus());
        }
    }
}
