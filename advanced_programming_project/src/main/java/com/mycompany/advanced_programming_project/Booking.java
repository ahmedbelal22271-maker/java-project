/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author abdoh
 */
import java.time.LocalDate;
import java.time.Period;

public class Booking {
    private String bookingId;
    private String status;
    private User   user;
    private Vehicle vehicle;
    private double totalCost;
    private Payment payment;

    public Booking(String bookingId,  String status, User user, Vehicle vehicle, double totalCost, Payment payment) {
        this.bookingId = bookingId;
        this.status = status;
        this.user = user;
        this.vehicle = vehicle;
        this.totalCost = totalCost;
        this.payment = payment;
    }

    

   public void confirm_booking(){
       status="Booking Confirmed";
       vehicle.decrementNumberAvailable();
   }
   
    public void cancel_booking(){

        status="Booking cancelled";
        vehicle.incrementNumberAvailable();
        
       
   }

   public void setPayment(Payment payment){
        this.payment = payment;
   }
    
}
