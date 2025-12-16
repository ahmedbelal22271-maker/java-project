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
    protected String vehicleId;
    protected static int numberOfVehicles;
    protected Boolean isAvailable;
    protected String manufacturer;
    protected String model;
    protected int numberAvailable;
    protected float rentalRatePerDay;
    protected int year;
    protected String imageFilePath;

    Vehicle(String manufacturer,String model,int numberAvailable,float rentalRatePerDay,int year){
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.numberAvailable = numberAvailable;
        imageFilePath = null;
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
