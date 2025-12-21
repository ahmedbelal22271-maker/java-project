package com.mycompany.advanced_programming_project;

import java.time.LocalDate;

public class Payment {

    private double amount;
    private Booking booking;
    private String paymentMethod;
    private String status;

    public Payment(double amount, Booking booking, String payment_method) {
        this.amount = amount;
        this.booking = booking;
        this.paymentMethod = payment_method;
//        process_payment(bookingTotal);
    }


public void process_payment(double bookingTotal) { //car price

    if (amount <= 0) {
        status = "failed";

    }
    // CASH PAYMENT
    if (paymentMethod.equalsIgnoreCase("cash")) {
        boolean ok = amount >= bookingTotal;
        status = ok ? "successful" : "failed";
    }

}

    public void send_receipt() {
        System.out.println("Payment Method: " + paymentMethod);
        System.out.println("Amount:" + amount);
        System.out.println("Status :" + status);

    }
}
