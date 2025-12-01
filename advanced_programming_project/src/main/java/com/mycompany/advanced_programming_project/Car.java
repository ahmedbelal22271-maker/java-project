/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Car extends Vehicle{
    String fuelType;
    Boolean isFamilyCar;
    int numberOfSeats;
    int EngineInHorsePower;
    
    Car(String manufacturer,
            String model,
            int year,
            float rentalRatePerDay,
            int EngineInHorsePower,
            int numberAvailable,
            String fuelType,
            Boolean isFamilyCar,
            int numberOfSeats
            ){
        super();
        this.manufacturer = manufacturer;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.EngineInHorsePower = EngineInHorsePower;
        this.numberAvailable = numberAvailable;
        this.fuelType = fuelType;
        this.isFamilyCar = isFamilyCar;
        this.numberOfSeats = numberOfSeats;
        
        System.out.println("This is a Car");
    }
    
    void display_info(){
        System.out.println("this should display the information gui later on");
    }
}
