/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Vehicle {
    String vehicleId;
    static int numberOfVehicles;
    Boolean isAvailable;
    String manufacturer;
    String model;
    int numberAvailable;
    float rentalRatePerDay;
    int year;

    Vehicle(String manufacturer,String model,int numberAvailable,float rentalRatePerDay,int year){
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.numberAvailable = numberAvailable;
        numberOfVehicles++;
        vehicleId = String.valueOf(numberOfVehicles);
    }

    void decrementNumberAvailable(){
        numberAvailable--;
    }
    void incrementNumberAvailable(){
        numberAvailable++;
    }

}
