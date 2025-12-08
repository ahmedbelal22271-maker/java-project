/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.advanced_programming_project;


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







    }
}
