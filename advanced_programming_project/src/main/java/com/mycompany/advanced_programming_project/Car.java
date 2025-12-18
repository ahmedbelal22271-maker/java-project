/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Car extends Vehicle implements Displayable{
    String fuelType;
    int numberOfSeats;

    Car(String manufacturer, String model, int year, float rentalRatePerDay, int numberAvailable, String fuelType, int numberOfSeats){
        super(manufacturer,model,numberAvailable,rentalRatePerDay,year);
        this.fuelType = fuelType;
        this.numberOfSeats = numberOfSeats;
        if (model.equals("SUV") & (numberOfSeats == 4 || numberOfSeats == 6)){
            imageFilePath = "/images/suv.jpeg";
        }
        if (model.equals("Sedan") & numberOfSeats == 4){
            imageFilePath = "/images/sedan.jpeg";
        }
        if (model.equals("Hatchback") & numberOfSeats == 4){
            imageFilePath = "/images/hatchback.jpeg";
        }
        if (model.equals("Coupe") & numberOfSeats == 2){
            imageFilePath = "/images/coupe.jpeg";
        }
        if (fuelType.equals("Electric")){
            imageFilePath = "/images/electric_car.jpeg";
        }
    }


    
    public void displayInfo(){
        System.out.println("this should display the information gui later on");
    }

    public String getFuelType(){
        return fuelType;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }


}
