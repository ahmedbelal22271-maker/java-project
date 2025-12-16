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

    private String type;

    Bike(String manufacturer,
        String model,
        int year,
        float rentalRatePerDay,
        int numberAvailable,
        String type){
        super(manufacturer,model,numberAvailable,rentalRatePerDay,year);
        this.type = type;

    }

    public void displayInfo(){
        System.out.println("The vehicle got displayed");
    }
}
