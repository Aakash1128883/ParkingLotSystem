package com.parking.service;

import com.parking.model.ParkingBill;
import com.parking.model.ParkingTicket;
import com.parking.model.Payment;
import com.parking.repository.PaymentRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PaymentService {
    private PaymentRepository paymentRepository;
    private ParkingService parkingService;

    public PaymentService(PaymentRepository paymentRepository, ParkingService parkingService) {
        this.paymentRepository = paymentRepository;
        this.parkingService = parkingService;
    }

    // Simulated payment: "success" decides PAID or FAILED
    public Payment processPayment(ParkingTicket ticket, ParkingBill bill, String method, boolean success) {
        String status = success ? "PAID" : "FAILED";
        Payment payment = new Payment(paymentRepository.generatePaymentId(),
                paymentRepository.generateReceiptId(), bill.getTicketId(),
                bill.getTotalAmount(), method, LocalDateTime.now(), status);
        paymentRepository.save(payment);

        if (success) {
            parkingService.completeExit(ticket, bill.getExitTime());   // close ticket + free slot
        }
        return payment;
    }

    public ArrayList<Payment> getAllPayments() { return paymentRepository.getAllPayments(); }
}
