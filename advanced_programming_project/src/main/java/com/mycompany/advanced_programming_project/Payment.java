package com.mycompany.advanced_programming_project;

import java.time.LocalDate;

public class Payment {

    private double amount;
    private Booking booking;
//    private LocalDate payment_date;
//    private String payment_id;
    private String paymentMethod;
    private String status;

    public Payment(double amount, Booking booking, String payment_method) {
        this.amount = amount;
        this.booking = booking;
//        this.payment_date = LocalDate.now();
//        this.payment_id = payment_id;
        this.paymentMethod = payment_method;
//        process_payment(bookingTotal);
    }


//   public void process_payment(double bookingTotal) { //car price
//
//    if (amount <= 0) {
//        status = "failed";
//
//    }
//    // CASH PAYMENT
//    if (paymentMethod.equalsIgnoreCase("cash")) {
//        boolean ok = amount >= bookingTotal;
//        status = ok ? "successful" : "failed";
//    }
//
//}
//

//    public void send_receipt() {
//        System.out.println("Payment Id: " + payment);
//        System.out.println("Payment Method: " + paymentMethod);
//        System.out.println("Amount:" + amount);
//        System.out.println("Date: " + payment_date);
//        System.out.println("Status :" + status);
//
//    }
}
