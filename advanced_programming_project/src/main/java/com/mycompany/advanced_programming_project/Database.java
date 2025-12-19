package com.mycompany.advanced_programming_project;

import java.util.List;
import java.util.Random;
import java.util.ArrayList;

public class Database {

    // FIX 1: Initialize these lists immediately!
    // If you don't use "= new ArrayList<>()", they remain null and crash your app.
    static ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();
    static ArrayList<Car> carsList = new ArrayList<>();
    static ArrayList<Van> vansList = new ArrayList<>();
    static ArrayList<Bike> bikesList = new ArrayList<>();
    static User[] userArray = {new User(
            "1",
            "Alice Johnson",
            "alice.johnson@example.com",
            "555-123-4567",
            "1234567.89"
    ),

            new User(
                    "2",
                    "Mark Stevens",
                    "mark.stevens@example.com",
                    "555-987-6543",
                    "9876543.21"
            ),

            new User(
                    "3",
                    "Sofia Ramirez",
                    "sofia.ramirez@example.com",
                    "555-777-8888",
                    "5678901.34"
            )};
    static User currentUser = null;
    static Vehicle currentVehicle = null;
    static Booking currentBooking = null;


    // FIX 2: Changed to 'static' so you can call it from anywhere without 'new VehicleArrayList()'
    public static void generateData() {
        Random rand = new Random();

        // Optional: Clear lists so you don't get duplicates if you call this twice
        carsList.clear();
        vansList.clear();
        bikesList.clear();

        // ==========================================
        // 1. GENERATE 30 RANDOM CARS
        // ==========================================
        String[] carMakes = {"Toyota", "Honda", "BMW", "Ford", "Mercedes"};
        String[] carModels = {"SUV", "Sedan", "Hatchback", "Coupe"};
        String[] fuels = {"Petrol", "Diesel", "Electric"};

        for (int i = 0; i < 30; i++) {
            String make = carMakes[rand.nextInt(carMakes.length)];
            String model = carModels[rand.nextInt(carModels.length)];
            String fuel = fuels[rand.nextInt(fuels.length)];

            int year = 2015 + rand.nextInt(10);
            float rate = 40 + rand.nextInt(60);
            int hp = 100 + rand.nextInt(200);

            int seats = 4;
            if (model.equals("Coupe")) {
                seats = 2;
            } else if (model.equals("SUV")) {
                seats = rand.nextBoolean() ? 4 : 6;
            }

            carsList.add(new Car(make, model, year, rate,5, fuel, seats));
        }

        // ==========================================
        // 2. GENERATE 30 RANDOM VANS
        // ==========================================
        String[] vanMakes = {"Ford", "Renault", "Mercedes", "Volkswagen"};

        for (int i = 0; i < 30; i++) {
            String make = vanMakes[rand.nextInt(vanMakes.length)];
            int year = 2018 + rand.nextInt(7);
            float rate = 60 + rand.nextInt(50);
            int hp = 100 + rand.nextInt(100);
            double cargo = 800 + rand.nextInt(1000);

            vansList.add(new Van(make, "Transporter", 3, year, rate, hp, cargo));
        }

        // ==========================================
        // 3. GENERATE 30 RANDOM BIKES
        // ==========================================
        String[] bikeMakes = {"Yamaha", "Ducati", "Kawasaki", "Harley"};
        String[] bikeModels = {"Motor Bike", "Racing Motor Bike", "Motor Skooter"};

        for (int i = 0; i < 30; i++) {
            String make = bikeMakes[rand.nextInt(bikeMakes.length)];
            String model = bikeModels[rand.nextInt(bikeModels.length)];
            int year = 2020 + rand.nextInt(5);
            float rate = 20 + rand.nextInt(30);

            bikesList.add(new Bike(make, model, year, rate, 10, model));
        }
    }

    // FIX 3: Removed the weird "};" and fixed the parameter type
    public static void assignArrayList(ArrayList<Vehicle> arrayList){
        vehicleArrayList = arrayList;
    }
    // Inside VehicleArrayList.java
    public static List<Vehicle> filteredList;

    public static void assignArrayList(List<Vehicle> list) {
        filteredList = list;
    }

    public static List<Vehicle> getFilteredList() {
        return filteredList;
    }
}