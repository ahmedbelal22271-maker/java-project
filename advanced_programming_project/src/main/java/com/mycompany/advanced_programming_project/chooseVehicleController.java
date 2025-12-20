package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;
import java.util.ArrayList;

public class chooseVehicleController {

    @FXML private ChoiceBox<String> myChoiceBox, fuelTypeChoiceBox, modelChoiceBox, typeChoiceBox;
    @FXML private Label usernameLabel, fuelType_EngineInHorsePower_typeLabel, model_cargoCapacity_nullLabel,
            numberOfSeats_null_nullLabel, cargoCapacityLabel;
    @FXML private TextField fuelType_EngineInHorsePower_typeTextField, model_cargoCapacity_nullTextField,
            numberOfSeats_null_nullTextField;
    @FXML private Spinner<Integer> horsepowerSpinner, cargoCapacitySpinner, noOfSeatsSpinner;

    @FXML
    private void initialize() {
        Database.generateData();

        // 1. Setup ChoiceBoxes
        myChoiceBox.getItems().addAll("Car", "Van", "Bike");
        myChoiceBox.setValue("select a vehicle");

        fuelTypeChoiceBox.getItems().addAll("Petrol", "Diesel", "Electric");
        typeChoiceBox.getItems().addAll("Motor Bike", "Motor Skooter", "Racing Motor Bike");
        modelChoiceBox.getItems().addAll("SUV", "Sedan", "Hatchback", "Coupe");

        // 2. Setup Spinners using the Safe Method
        setupSafeSpinner(horsepowerSpinner, 70, 350, 130, 5);
        setupSafeSpinner(cargoCapacitySpinner, 0, 5000, 500, 50);
        setupSafeSpinner(noOfSeatsSpinner, 0, 6, 4, 1);

        // 3. Set Initial Visibility
        setVisible(false, fuelType_EngineInHorsePower_typeLabel, model_cargoCapacity_nullLabel,
                numberOfSeats_null_nullLabel, fuelType_EngineInHorsePower_typeTextField, fuelTypeChoiceBox,
                horsepowerSpinner, typeChoiceBox, model_cargoCapacity_nullTextField, modelChoiceBox,
                cargoCapacitySpinner, cargoCapacityLabel, numberOfSeats_null_nullTextField, noOfSeatsSpinner);

        usernameLabel.setText("Hello, " + Database.currentUser.getName());

        myChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                switch (newValue) {
                    case "Car":
                        updateLabels("Fuel Type:", "Model:", "Number of Seats:");
                        setVisible(true, fuelType_EngineInHorsePower_typeLabel, model_cargoCapacity_nullLabel,
                                numberOfSeats_null_nullLabel, fuelTypeChoiceBox, modelChoiceBox, noOfSeatsSpinner);
                        setVisible(false, fuelType_EngineInHorsePower_typeTextField, horsepowerSpinner, typeChoiceBox,
                                model_cargoCapacity_nullTextField, cargoCapacitySpinner, cargoCapacityLabel,
                                numberOfSeats_null_nullTextField);
                        break;
                    case "Van":
                        updateLabels("Engine in Horsepower:", "Cargo Capacity:", "null");
                        setVisible(true, fuelType_EngineInHorsePower_typeLabel, model_cargoCapacity_nullLabel,
                                horsepowerSpinner, cargoCapacitySpinner);
                        setVisible(false, numberOfSeats_null_nullLabel, fuelType_EngineInHorsePower_typeTextField,
                                fuelTypeChoiceBox, typeChoiceBox, model_cargoCapacity_nullTextField, modelChoiceBox,
                                cargoCapacityLabel, numberOfSeats_null_nullTextField, noOfSeatsSpinner);
                        break;
                    case "Bike":
                        updateLabels("Bike Type:", "null", "null");
                        setVisible(true, fuelType_EngineInHorsePower_typeLabel, typeChoiceBox);
                        setVisible(false, model_cargoCapacity_nullLabel, numberOfSeats_null_nullLabel,
                                fuelType_EngineInHorsePower_typeTextField, fuelTypeChoiceBox, horsepowerSpinner,
                                model_cargoCapacity_nullTextField, modelChoiceBox, cargoCapacitySpinner,
                                cargoCapacityLabel, numberOfSeats_null_nullTextField, noOfSeatsSpinner);
                        break;
                }
            }
        });
    }

    // Helper to set visibility for multiple nodes at once
    private void setVisible(boolean visible, Control... controls) {
        for (Control c : controls) {
            c.setVisible(visible);
        }
    }

    private void updateLabels(String l1, String l2, String l3) {
        fuelType_EngineInHorsePower_typeLabel.setText(l1);
        model_cargoCapacity_nullLabel.setText(l2);
        numberOfSeats_null_nullLabel.setText(l3);
    }

    // --- ENHANCED HELPER METHOD: HANDLES TYPES AND RANGES ---
    private void setupSafeSpinner(Spinner<Integer> spinner, int min, int max, int initial, int step) {
        SpinnerValueFactory.IntegerSpinnerValueFactory factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initial, step);

        StringConverter<Integer> safeConverter = new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) {
                return object.toString();
            }

            @Override
            public Integer fromString(String string) {
                try {
                    if (string == null || string.trim().isEmpty()) return min;
                    int value = Integer.parseInt(string);
                    if (value < min) return min;
                    else if (value > max) return max;
                    return value;
                } catch (NumberFormatException e) {
                    return min;
                }
            }
        };

        factory.setConverter(safeConverter);
        spinner.setValueFactory(factory);
        spinner.setEditable(true);
    }

    @FXML
    private void handleSubmitButton(ActionEvent event) {
        System.out.println("the submit button was clicked");
        ArrayList<Vehicle> list = new ArrayList<>();
        String vehicleChoice = myChoiceBox.getValue();
        System.out.println("the vehicle chosen is: " + vehicleChoice);

        if ("Car".equals(vehicleChoice)) {
            System.out.println("The vehicle is indeed a car");
            String fuelTypeChoice = fuelTypeChoiceBox.getValue();
            String modelChoice = modelChoiceBox.getValue();
            int numberOfSeatsChoice = noOfSeatsSpinner.getValue();
            for (Car car : Database.carsList) {
                if (car.getFuelType().equals(fuelTypeChoice) &&
                        car.getNumberOfSeats() >= numberOfSeatsChoice &&
                        car.getModel().equals(modelChoice)) {
                    list.add(car);
                }
            }
        } else if ("Van".equals(vehicleChoice)) {
            System.out.println("the vehicle is indeed a van");
            int horsepowerChoice = horsepowerSpinner.getValue();
            int cargoCapacityChoice = cargoCapacitySpinner.getValue();
            for (Van van : Database.vansList) {
                if (van.getEngineInHorsePower() >= horsepowerChoice &&
                        van.getCargoCapacity() >= cargoCapacityChoice) {
                    list.add(van);
                }
            }
        } else if ("Bike".equals(vehicleChoice)) {
            System.out.println("the vehicle is indeed a bike");
            String typeChoice = typeChoiceBox.getValue();
            for (Bike bike : Database.bikesList) {
                if (bike.getType().equals(typeChoice)) {
                    list.add(bike);
                }
            }
        }

        Database.assignArrayList(list);
        for (Vehicle v : list) {
            System.out.println(v);
        }

        if (!list.isEmpty()) {
            System.out.println("The vehicle arraylist is indeed not empty");
            SceneSwitcher.switchTo("/display-vehicle.fxml", "Vehicle Display Scene");
        }
    }
}