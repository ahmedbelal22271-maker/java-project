/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.advanced_programming_project;

/**
 *
 * @author saifa
 */
public class User {

    private String userId;
    private String name;
    private String email;
    private String phoneNumber;
    private String licenceNumber;
    //Booking[]history_array ;         // from booking class 
    boolean license_flag;

    public User(String userId, String name, String email, String phoneNumber, String licenceNumber) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.licenceNumber = licenceNumber;
    }

//    String verified_licenses[] = {"11133", "11322", "12231", "23412"};    //Array of verified licenses   //img valid license numbers / in real it should check it from هيئه المرور

//    public void verify_license() {
//        for (int i = 0; i < verified_licenses.length; i++) {       // looping and check if the entered license is part of the verified license or not
//
//            if (licenceNumber == verified_licenses[i]) {
//
//                license_flag = true;
//                break;
//            } else {
//
//                license_flag = false;
//            }
//        }
//
//        if (license_flag) {
//            System.out.println("license is valid :) ");
//
//        } else {
//            System.out.println("license is not valid :( ");
//
//        }
//    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public String getUserId(){
        return userId;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getLicenseNo(){
        return licenceNumber;
    }


}
