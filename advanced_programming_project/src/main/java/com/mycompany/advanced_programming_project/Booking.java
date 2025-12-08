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
     private String booking_id;
    private LocalDate   start_date;
    private LocalDate   end_date;
    private String status;
    private User   user;
    private Vehicle vehicle;
    private double totalCost;
    private Payment payment;

    public Booking(String booking_id, LocalDate start_date, LocalDate end_date, String status, User user, Vehicle vehicle, double totalCost, Payment payment) {
        this.booking_id = booking_id;
        this.start_date = start_date;
        this.end_date = end_date;
        this.status = status;
        this.user = user;
        this.vehicle = vehicle;
        this.totalCost = totalCost;
        this.payment = payment;
    }

    
    
  public void calculate_duration(){      //calculates the difference between the end and start dates
      
      Period p = Period.between(start_date,end_date);
      System.out.println("Booking duration:");
      System.out.println(p.getYears() + " years");
      System.out.println(p.getMonths() + " months");
      System.out.println(p.getDays() + " days");
   }
   public void confirm_booking(){
       System.out.println("Booking is confirmed succesfully");
   }
   
    public void cancel_booking(){
        
        System.out.println("Booking has been canceled");
        
       
   }
    
}
