/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Van extends Vehicle implements Displayable{
    private int EngineInHorsePower;
    private double cargoCapacity;

    Van(String manufacturer,
        String model,
        int numberAvailable,
        int year,
        float rentalRatePerDay,
        int EngineInHorsePower,
        double cargoCapacity
    ){
        super(manufacturer,model,numberAvailable,rentalRatePerDay,year);
        this.EngineInHorsePower = EngineInHorsePower;
        this.cargoCapacity = cargoCapacity;

        imageFilePath = "images/normal van.jpeg";

    }

    public void displayInfo(){
        System.out.println("The vehicle got displayed");
    }

    int getEngineInHorsePower(){
        return EngineInHorsePower;
    }

    double getCargoCapacity(){
        return cargoCapacity;
    }
}
