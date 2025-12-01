/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Bike extends Vehicle implements Displayable{

    String type;

    Bike(String manufacturer,
        String model,
        int year,
        float rentalRatePerDay,
        int engineCapacity,
        int numberAvailable,
        String type){
        super();
        this.manufacturer = manufacturer;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.numberAvailable = numberAvailable;
        this.type = type;

        System.out.println("This is a Car");
    }

    public void displayInfo(){
        System.out.println("The vehicle got displayed");
    }
}
