/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.advanced_programming_project;


import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author marwa
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("please enter your email");
        User[] userArray = {new User(
                1,
                "Alice Johnson",
                "alice.johnson@example.com",
                "555-123-4567",
                1234567.89
        ),

        new User(
                2,
                "Mark Stevens",
                "mark.stevens@example.com",
                "555-987-6543",
                9876543.21
        ),

        new User(
                3,
                "Sofia Ramirez",
                "sofia.ramirez@example.com",
                "555-777-8888",
                5678901.34
        )};
        Scanner emailInput = new Scanner(System.in);
        String email = emailInput.nextLine();

        boolean EnteredUser = false;

        while (!EnteredUser){
            for (User user : userArray){
                if (Objects.equals(email, user.getEmail())){
                    System.out.println("Welcome back, " + user.getName());
                    EnteredUser = true;
                }
            }
            if (!EnteredUser){
                System.out.println("Invalid email, please try again");
                email = emailInput.nextLine();
            }
        }

        Vehicle[] vehicles = new Vehicle[] {
                new Bike("Trek", "Marlin 7", 2021, 15.5f, 5, "Mountain"),
                new Van("Ford", "Transit", 3, 2021, 45.0f, 150, true),
                new Car("Toyota", "Corolla", 2020, 40.0f, 132, 4, "Petrol", true, 5),
                new Bike("Giant", "Escape 3", 2020, 12.0f, 8, "Road"),
                new Car("Honda", "Civic", 2022, 42.5f, 158, 2, "Petrol", true, 5),
                new Van("Mercedes-Benz", "Sprinter", 5, 2020, 50.0f, 180, false),
                new Bike("Cannondale", "Quick 4", 2019, 13.5f, 6, "Hybrid"),
                new Car("BMW", "X3", 2021, 70.0f, 200, 3, "Diesel", false, 5),
                new Van("Nissan", "NV3500", 4, 2019, 42.5f, 140, false),
                new Bike("Specialized", "Rockhopper", 2022, 16.0f, 3, "Mountain")
        };

        // Array of 10 Bikes
        Bike[] bikes = new Bike[] {
                new Bike("Trek", "Marlin 7", 2021, 15.5f, 5, "Mountain"),
                new Bike("Giant", "Escape 3", 2020, 12.0f, 8, "Road"),
                new Bike("Specialized", "Rockhopper", 2022, 16.0f, 3, "Mountain"),
                new Bike("Cannondale", "Quick 4", 2019, 13.5f, 6, "Hybrid"),
                new Bike("Scott", "Aspect 950", 2023, 18.0f, 2, "Mountain"),
                new Bike("Bianchi", "C-Sport 1", 2021, 14.5f, 4, "Road"),
                new Bike("Santa Cruz", "Chameleon", 2022, 20.0f, 1, "Mountain"),
                new Bike("Merida", "Speeder 300", 2020, 12.5f, 7, "Road"),
                new Bike("Kona", "Dew Plus", 2021, 15.0f, 3, "Hybrid"),
                new Bike("GT", "Aggressor Pro", 2023, 17.5f, 2, "Mountain")
        };

// Array of 10 Vans
        Van[] vans = new Van[] {
                new Van("Ford", "Transit", 3, 2021, 45.0f, 150, true),
                new Van("Mercedes-Benz", "Sprinter", 5, 2020, 50.0f, 180, false),
                new Van("Ram", "ProMaster", 2, 2022, 48.0f, 160, true),
                new Van("Nissan", "NV3500", 4, 2019, 42.5f, 140, false),
                new Van("Chevrolet", "Express", 1, 2023, 55.0f, 175, true),
                new Van("Volkswagen", "Crafter", 2, 2021, 49.0f, 165, false),
                new Van("Fiat", "Ducato", 3, 2022, 47.0f, 155, true),
                new Van("Renault", "Master", 6, 2020, 43.0f, 150, false),
                new Van("Toyota", "HiAce", 4, 2023, 50.5f, 160, true),
                new Van("Hyundai", "H350", 2, 2021, 44.0f, 145, false)
        };

// Array of 10 Cars
        Car[] cars = new Car[] {
                new Car("Toyota", "Corolla", 2020, 40.0f, 132, 4, "Petrol", true, 5),
                new Car("Honda", "Civic", 2022, 42.5f, 158, 2, "Petrol", true, 5),
                new Car("BMW", "X3", 2021, 70.0f, 200, 3, "Diesel", false, 5),
                new Car("Audi", "A4", 2023, 65.0f, 190, 2, "Diesel", false, 5),
                new Car("Ford", "Focus", 2020, 38.0f, 150, 3, "Petrol", true, 5),
                new Car("Chevrolet", "Malibu", 2021, 45.0f, 160, 4, "Petrol", true, 5),
                new Car("Volkswagen", "Passat", 2022, 50.0f, 170, 3, "Diesel", false, 5),
                new Car("Hyundai", "Elantra", 2019, 35.0f, 140, 5, "Petrol", true, 5),
                new Car("Kia", "Optima", 2021, 42.0f, 155, 4, "Petrol", true, 5),
                new Car("Mazda", "6", 2020, 44.0f, 165, 3, "Petrol", true, 5)
        };

        System.out.println("Choose the type of vehicle");
        System.out.println("1-Car 2-Van 3-Bike 4-exit the program");
        Scanner inputscanner = new Scanner(System.in);
        int input = 0;
        boolean validInput = false;
        int[] validInputsArray1 = {1,2,3,4};
        while (!validInput){
            try{
                input = inputscanner.nextInt();
                for (int number : validInputsArray1){
                    if (input == number){
                        validInput = true;
                        break;
                    }
                }
                System.out.println("This is not a correct value, please enter an integer from 1 to 4");
            }
            catch (InputMismatchException e){
                System.out.println("This is not a valid input, please enter an integer from 1 to 4");
            }
        }
        if (input == 1){
            int currentCarIndex = 0;
            cars[currentCarIndex].displayInfo();
            int[] validInputsArray2 = {1,2,3,4,5};
            System.out.println("1-book now  2-go to the next car  3-go to the previous car  4-choose another category  5-exit the program");
            try{
                input = inputscanner.nextInt();
            }
            catch (InputMismatchException e){
                System.out.println("This is not a valid input, please enter an integer from 1 to 4");
            }

        }







    }
}
