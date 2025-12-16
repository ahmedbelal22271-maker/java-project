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

        if (model.equals("Motor Bike")){
            imageFilePath = "/images/normal motor bike.jpeg";
        }
        if (model.equals("Racing Motor Bike")){
            imageFilePath = "/images/racing motor bike.jpeg";
        }
        if (model.equals("Motor Skooter")){
            imageFilePath = "images/motor skooter.jpeg";
        }
    }

    public void displayInfo(){
        System.out.println("The vehicle got displayed");
    }

    String getType(){
        return type;
    }
}
