package com.parking.model;

import java.time.LocalDateTime;

public class Payment {
    private String paymentId;
    private String receiptId;
    private String ticketId;
    private int amount;
    private String method;
    private LocalDateTime paymentTime;
    private String status;   // PAID or FAILED

    public Payment(String paymentId, String receiptId, String ticketId, int amount,
                   String method, LocalDateTime paymentTime, String status) {
        this.paymentId = paymentId;
        this.receiptId = receiptId;
        this.ticketId = ticketId;
        this.amount = amount;
        this.method = method;
        this.paymentTime = paymentTime;
        this.status = status;
    }

    public String getPaymentId() { return paymentId; }
    public String getReceiptId() { return receiptId; }
    public String getTicketId() { return ticketId; }
    public int getAmount() { return amount; }
    public String getMethod() { return method; }
    public LocalDateTime getPaymentTime() { return paymentTime; }
    public String getStatus() { return status; }
}
