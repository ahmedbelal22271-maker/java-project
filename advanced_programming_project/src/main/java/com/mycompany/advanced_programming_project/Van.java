/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author marwa
 */
public class Van {
    Boolean isRefrigerated;

    Van(String manufacturer,
        String model,
        int year,
        float rentalRatePerDay,
        int engineCapacity,
        int numberAvailable,
        Boolean isRefrigerated
    ){
        super();
        this.manufacturer = manufacturer;
        this.year = year;
        this.rentalRatePerDay = rentalRatePerDay;
        this.engineCapacity = engineCapacity;
        this.numberAvailable = numberAvailable;
        this.isRefrigerated = isRefrigerated;

        System.out.println("This is a Van");
    }
}
