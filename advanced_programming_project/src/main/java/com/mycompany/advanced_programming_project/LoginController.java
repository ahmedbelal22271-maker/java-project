package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private Button loginButton;
    @FXML private Label invalidLoginLabel;
    @FXML private TextField nameField, userIdField, phoneNoField, licenseNoField, emailField;

    @FXML
    private void initialize() {
        invalidLoginLabel.setVisible(false);
    }

    @FXML
    private void handleLoginButton(ActionEvent event) {
        String name = nameField.getText();
        String userId = userIdField.getText();
        String email = emailField.getText();
        String phoneNo = phoneNoField.getText();
        String licenseNo = licenseNoField.getText();

        boolean foundUser = false;

        for (User user : Database.userArray) {
            boolean isCorrectName = name.equals(user.getName());
            boolean isCorrectUserId = userId.equals(user.getUser_id());
            boolean isCorrectEmail = email.equals(user.getEmail());
            boolean isCorrectPhoneNo = phoneNo.equals(user.getPhoneNumber());
            boolean isCorrectLicenseNo = licenseNo.equals(user.getLicenseNumber());

            if (isCorrectEmail && isCorrectName && isCorrectLicenseNo && isCorrectPhoneNo && isCorrectUserId) {
                foundUser = true;
                Database.currentUser = user;
                break;
            }
        }

        if (foundUser) {
            SceneSwitcher.switchTo("/choose-vehicle.fxml", "Vehicle Rental System");
        } else {
            System.out.println("Login invalid");
            invalidLoginLabel.setVisible(true);
        }
    }
}