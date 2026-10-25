package com.parking.repository;

import com.parking.model.Payment;
import java.util.ArrayList;

public class PaymentRepository {
    private ArrayList<Payment> payments = new ArrayList<>();
    private int paymentCounter = 1;
    private int receiptCounter = 1;

    public String generatePaymentId() { return String.format("PAY%03d", paymentCounter++); }
    public String generateReceiptId() { return String.format("RCT%03d", receiptCounter++); }

    public void save(Payment payment) { payments.add(payment); }
    public ArrayList<Payment> getAllPayments() { return payments; }
}
