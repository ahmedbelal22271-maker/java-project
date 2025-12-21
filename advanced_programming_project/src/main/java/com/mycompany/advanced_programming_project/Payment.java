package com.mycompany.advanced_programming_project;

import java.time.LocalDate;

public class Payment {

    private double amount;
    private Booking booking;
    private LocalDate paymentDate;
    private String paymentMethod;
    private String status;

    public Payment(double amount, Booking booking, String payment_method) {
        this.amount = amount;
        this.booking = booking;
        this.paymentMethod = payment_method;

    }

    public Payment(double amount, Booking booking, String payment_method, LocalDate paymentDate, String status) {
        this.amount = amount;
        this.booking = booking;
        this.paymentMethod = payment_method;
        this.paymentDate = paymentDate;
        this.status = status;

    }




    public void send_receipt() {
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount:" + amount);
        System.out.println("Status :" + status);
        System.out.println("Payment Date :" + paymentDate);

    }
}
