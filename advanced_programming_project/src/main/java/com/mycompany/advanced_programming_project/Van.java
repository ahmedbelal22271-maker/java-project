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
    Boolean isRefrigerated;
    int EngineInHorsePower;

    Van(String manufacturer,
        String model,
        int numberAvailable,
        int year,
        float rentalRatePerDay,
        int EngineInHorsePower,
        Boolean isRefrigerated
    ){
        super(manufacturer,model,numberAvailable,rentalRatePerDay,year);
        this.isRefrigerated = isRefrigerated;
        this.EngineInHorsePower = EngineInHorsePower;

    }

    public void displayInfo(){
        System.out.println("The vehicle got displayed");
    }
}
