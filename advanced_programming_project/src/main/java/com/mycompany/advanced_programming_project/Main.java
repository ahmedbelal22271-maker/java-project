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

        Vehicle[] vehicleArray = {
                
        }





    }
}
