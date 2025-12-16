package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;


public class chooseVehicleController {
    public ChoiceBox<String> myChoiceBox;
    public Label usernameLabel;
    public Label fuelType_EngineInHorsePower_typeLabel;
    public Label model_cargoCapacity_nullLabel;
    public Label numberOfSeats_null_nullLabel;
    public TextField fuelType_EngineInHorsePower_typeTextField;
    public TextField model_cargoCapacity_nullTextField;
    public TextField numberOfSeats_null_nullTextField;
    public ChoiceBox fuelTypeChoiceBox;
    public Spinner HorsepowerSpinner;
    public ChoiceBox modelChoiceBox;
    public Spinner cargoCapacitySpinner;
    public ChoiceBox typeChoiceBox;
    public Spinner noOfSeatsSpinner;
    public Label cargoCapacityLabel;

    @FXML
    public void initialize(){
        myChoiceBox.getItems().addAll("Car", "Van","Bike");
        myChoiceBox.setValue("select a vehicle");
        fuelType_EngineInHorsePower_typeLabel.setVisible(false);
        model_cargoCapacity_nullLabel.setVisible(false);
        numberOfSeats_null_nullLabel.setVisible(false);
        fuelType_EngineInHorsePower_typeTextField.setVisible(false);
        fuelTypeChoiceBox.setVisible(false);
        fuelTypeChoiceBox.getItems().addAll("Petrol","Diesel","Electric");
        HorsepowerSpinner.setVisible(false);

        typeChoiceBox.setVisible(false);
        model_cargoCapacity_nullTextField.setVisible(false);
        modelChoiceBox.setVisible(false);
        cargoCapacitySpinner.setVisible(false);
        cargoCapacityLabel.setVisible(false);
        numberOfSeats_null_nullTextField.setVisible(false);
        noOfSeatsSpinner.setVisible(false);


        usernameLabel.setText("Hello, " + currentUserClass.currentUser.getName());

        myChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {

            // Check what the NEW value is and update the label accordingly
            if (newValue != null) {
                switch (newValue) {
                    case "Car":
                        fuelType_EngineInHorsePower_typeLabel.setText("Fuel Type:");
                        model_cargoCapacity_nullLabel.setText("Model:");
                        numberOfSeats_null_nullLabel.setText("Number of Seats:");
                        fuelType_EngineInHorsePower_typeLabel.setVisible(true);
                        model_cargoCapacity_nullLabel.setVisible(true);
                        numberOfSeats_null_nullLabel.setVisible(true);
                        fuelType_EngineInHorsePower_typeTextField.setVisible(false);
                        fuelTypeChoiceBox.setVisible(true);
                        HorsepowerSpinner.setVisible(false);
                        typeChoiceBox.setVisible(false);
                        model_cargoCapacity_nullTextField.setVisible(false);
                        modelChoiceBox.setVisible(true);
                        cargoCapacitySpinner.setVisible(false);
                        cargoCapacityLabel.setVisible(false);
                        numberOfSeats_null_nullTextField.setVisible(false);
                        noOfSeatsSpinner.setVisible(true);
                        break;
                    case "Van":
                        fuelType_EngineInHorsePower_typeLabel.setText("Engine in Horsepower:");
                        model_cargoCapacity_nullLabel.setText("Cargo Capacity:");
                        numberOfSeats_null_nullLabel.setText("null:");
                        fuelType_EngineInHorsePower_typeLabel.setVisible(true);
                        model_cargoCapacity_nullLabel.setVisible(true);
                        numberOfSeats_null_nullLabel.setVisible(false);
                        fuelType_EngineInHorsePower_typeTextField.setVisible(false);
                        fuelTypeChoiceBox.setVisible(false);
                        HorsepowerSpinner.setVisible(true);
                        typeChoiceBox.setVisible(false);
                        model_cargoCapacity_nullTextField.setVisible(false);
                        modelChoiceBox.setVisible(false);
                        cargoCapacitySpinner.setVisible(true);
                        cargoCapacityLabel.setVisible(false);
                        numberOfSeats_null_nullTextField.setVisible(false);
                        noOfSeatsSpinner.setVisible(false);
                        break;
                    case "Bike":
                        fuelType_EngineInHorsePower_typeLabel.setText("Bike Type:");
                        model_cargoCapacity_nullLabel.setText("null");
                        numberOfSeats_null_nullLabel.setText("null");
                        fuelType_EngineInHorsePower_typeLabel.setVisible(true);
                        model_cargoCapacity_nullLabel.setVisible(false);
                        numberOfSeats_null_nullLabel.setVisible(false);
                        fuelType_EngineInHorsePower_typeTextField.setVisible(false);
                        fuelTypeChoiceBox.setVisible(false);
                        HorsepowerSpinner.setVisible(false);
                        typeChoiceBox.setVisible(true);
                        model_cargoCapacity_nullTextField.setVisible(false);
                        modelChoiceBox.setVisible(false);
                        cargoCapacitySpinner.setVisible(false);
                        cargoCapacityLabel.setVisible(false);
                        numberOfSeats_null_nullTextField.setVisible(false);
                        noOfSeatsSpinner.setVisible(false);
                        break;
                }
            }
        });

        // <--- 1. Add this so FXML can find it

    }



    @FXML
    void handleSubmitButton(ActionEvent event) { // <--- 2. Add 'public' (best practice)
        System.out.println("the submit button was clicked");
        String vehicleChoice = myChoiceBox.getValue();
        if (vehicleChoice.equals("Car")){

        }
        if (vehicleChoice.equals("Van")){

        }
        if (vehicleChoice.equals("Bike")){

        }


    } // <--- 3. No semicolon here
}
