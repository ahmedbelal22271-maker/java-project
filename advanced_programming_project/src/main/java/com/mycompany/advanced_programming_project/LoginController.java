package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    public Button loginButton;
    public TextField nameField;
    public TextField userIdField;
    public TextField phoneNoField;
    public TextField licenseNoField;
    public Label invalidLoginLabel;
    @FXML
    private TextField emailField;

    @FXML
    public void initialize(){
        invalidLoginLabel.setVisible(false);
    }

    @FXML
    public void handleLoginButton(ActionEvent event){

        String name = nameField.getText();
        String userId = userIdField.getText();
        String email = emailField.getText();
        String phoneNo = phoneNoField.getText();
        String licenseNo = licenseNoField.getText();

        boolean isCorrectName = false;
        boolean isCorrectUserId = false;
        boolean isCorrectEmail = false;
        boolean isCorrectPhoneNo = false;
        boolean isCorrectLicenseNo = false;
        User currentUser = null;
        boolean foundUser = false;

        for (User user : Database.userArray){
            isCorrectName = false;
            isCorrectUserId = false;
            isCorrectEmail = false;
            isCorrectPhoneNo = false;
            isCorrectLicenseNo = false;
            if (name.equals(user.getName())){
                isCorrectName = true;
                System.out.println("name is correct");
                //SceneSwitcher.switchTo("/choose-vehicle.fxml", "Choose Vehicle Interface");


            }
            if (userId.equals(user.getUser_id())){
                isCorrectUserId = true;
                //SceneSwitcher.switchTo("/choose-vehicle.fxml", "Choose Vehicle Interface");


            }
            if (email.equals(user.getEmail())){
                isCorrectEmail = true;
                //SceneSwitcher.switchTo("/choose-vehicle.fxml", "Choose Vehicle Interface");


            }
            if (phoneNo.equals(user.getPhone_number())){
                isCorrectPhoneNo = true;
                //SceneSwitcher.switchTo("/choose-vehicle.fxml", "Choose Vehicle Interface");


            }
            if (licenseNo.equals(user.getLicense_number())){
                isCorrectLicenseNo = true;
                //SceneSwitcher.switchTo("/choose-vehicle.fxml", "Choose Vehicle Interface");


            }
            if (isCorrectEmail & isCorrectName & isCorrectLicenseNo & isCorrectPhoneNo & isCorrectUserId){
                foundUser = true;
                currentUserClass.currentUser = user;
                break;
            }
        }

        if (foundUser){
            SceneSwitcher.switchTo("/choose-vehicle.fxml", "Vehicle Rental System");
        }
        else{
            System.out.println("Login invalid");
            invalidLoginLabel.setVisible(true);
        }

    }

}
