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

    private String user_id;
    private String name;
    private String email;
    private String phone_number;
    private String license_number;
    //Booking[]history_array ;         // from booking class 
    boolean license_flag;

    public User(String user_id, String name, String email, String phone_number, String license_number) {
        this.user_id = user_id;
        this.name = name;
        this.email = email;
        this.phone_number = phone_number;
        this.license_number = license_number;
    }

//    double verified_licenses[] = {11133, 11322, 12231, 23412};    //Array of verified licenses   //img valid license numbers / in real it should check it from هيئه المرور
//
//    public void verify_license() {
//        for (int i = 0; i < verified_licenses.length; i++) {       // looping and check if the entered license is part of the verified license or not
//
//            if (license_number == verified_licenses[i]) {
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
    //*********getters*************

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public String getUser_id(){

        return user_id;
    }

    public String getPhoneNumber() {
        return phone_number;
    }

    public String getLicenseNumber() {
        return license_number;
    }

    public String getUserId() {
        return user_id;
    }
    //*************setters************************

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phone_number) {
        this.phone_number = phone_number;
    }

    public void setLicenseNumber(String license_number) {
        this.license_number = license_number;
    }

}
