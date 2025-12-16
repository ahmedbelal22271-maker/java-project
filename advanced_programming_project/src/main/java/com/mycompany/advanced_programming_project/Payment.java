package com.mycompany.advanced_programming_project;
import java.time.LocalDate;

public class Payment {

    private double amount;
    private String booking_id;
    private LocalDate payment_date;
    private String payment_id;
    private String payment_method;
    private String status;

    public Payment(double amount, String booking_id, String payment_id, String payment_method,double bookingTotal) {
        this.amount = amount;
        this.booking_id = booking_id;
        this.payment_date = LocalDate.now();
        this.payment_id = payment_id;
        this.payment_method = payment_method;
        process_payment(bookingTotal);
    }


   public void process_payment(double bookingTotal) { //car price

    if (amount <= 0) {
        status = "failed";

    }
    // CASH PAYMENT
    if (payment_method.equalsIgnoreCase("cash")) {
        boolean ok = amount <= bookingTotal;
        status = ok ? "successful" : "failed";
        send_receipt();

    }
    
}
    

    public void send_receipt() {
        System.out.println("Payment Id: " + payment_id);
        System.out.println("Payment Method: " + payment_method);
        System.out.println("Amount:" + amount);
        System.out.println("Date: " + payment_date);
        System.out.println("Status :" + status);

    }
}
