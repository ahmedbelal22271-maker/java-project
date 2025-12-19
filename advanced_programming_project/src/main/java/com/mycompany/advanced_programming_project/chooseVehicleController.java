package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.StringConverter;

import java.util.ArrayList;

public class chooseVehicleController {
    public ChoiceBox<String> myChoiceBox;
    public Label usernameLabel;
    public Label fuelType_EngineInHorsePower_typeLabel;
    public Label model_cargoCapacity_nullLabel;
    public Label numberOfSeats_null_nullLabel;
    public TextField fuelType_EngineInHorsePower_typeTextField;
    public TextField model_cargoCapacity_nullTextField;
    public TextField numberOfSeats_null_nullTextField;
    public ChoiceBox<String> fuelTypeChoiceBox;
    public Spinner<Integer> horsepowerSpinner;
    public ChoiceBox<String> modelChoiceBox;
    public Spinner<Integer> cargoCapacitySpinner;
    public ChoiceBox<String> typeChoiceBox;
    public Spinner<Integer> noOfSeatsSpinner;
    public Label cargoCapacityLabel;

    @FXML
    public void initialize(){
        Database.generateData();

        // 1. Setup ChoiceBoxes
        myChoiceBox.getItems().addAll("Car", "Van","Bike");
        myChoiceBox.setValue("select a vehicle");

        fuelTypeChoiceBox.getItems().addAll("Petrol","Diesel","Electric");
        typeChoiceBox.getItems().addAll("Motor Bike","Motor Skooter","Racing Motor Bike");
        modelChoiceBox.getItems().addAll("SUV", "Sedan", "Hatchback", "Coupe");

        // 2. Setup Spinners using the Safe Method
        // Horsepower: Min 70, Max 350
        setupSafeSpinner(horsepowerSpinner, 70, 350, 130, 5);

        // Cargo: Min 0, Max 5000
        setupSafeSpinner(cargoCapacitySpinner, 0, 5000, 500, 50);

        // Seats: Min 0, Max 6
        setupSafeSpinner(noOfSeatsSpinner, 0, 6, 4, 1);

        // 3. Set Initial Visibility
        fuelType_EngineInHorsePower_typeLabel.setVisible(false);
        model_cargoCapacity_nullLabel.setVisible(false);
        numberOfSeats_null_nullLabel.setVisible(false);
        fuelType_EngineInHorsePower_typeTextField.setVisible(false);
        fuelTypeChoiceBox.setVisible(false);
        horsepowerSpinner.setVisible(false);
        typeChoiceBox.setVisible(false);
        model_cargoCapacity_nullTextField.setVisible(false);
        modelChoiceBox.setVisible(false);
        cargoCapacitySpinner.setVisible(false);
        cargoCapacityLabel.setVisible(false);
        numberOfSeats_null_nullTextField.setVisible(false);
        noOfSeatsSpinner.setVisible(false);

        usernameLabel.setText("Hello, " + Database.currentUser.getName());

        myChoiceBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
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
                        horsepowerSpinner.setVisible(false);
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
                        horsepowerSpinner.setVisible(true);
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
                        horsepowerSpinner.setVisible(false);
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
                    // Check for empty input
                    if (string == null || string.trim().isEmpty()) {
                        return min;
                    }

                    int value = Integer.parseInt(string);

                    // --- RANGE CHECKS ---
                    if (value < min) {
                        System.out.println("Input too low (" + value + "). Resetting to min: " + min);
                        return min;
                    } else if (value > max) {
                        System.out.println("Input too high (" + value + "). Resetting to max: " + max);
                        return max;
                    }

                    return value;

                } catch (NumberFormatException e) {
                    // Check for invalid text (e.g. "abc")
                    System.out.println("Invalid input '" + string + "'. Resetting to min: " + min);
                    return min;
                }
            }
        };

        factory.setConverter(safeConverter);
        spinner.setValueFactory(factory);
        spinner.setEditable(true);
    }

    @FXML
    void handleSubmitButton(ActionEvent event) {
        System.out.println("the submit button was clicked");
        ArrayList<Vehicle> list = new ArrayList<>();
        String vehicleChoice = myChoiceBox.getValue();
        System.out.println("the vehicle chosen is: " + vehicleChoice);

        if (vehicleChoice.equals("Car")){
            System.out.println("The vehicle is indeed a car");
            String fuelTypeChoice = fuelTypeChoiceBox.getValue();
            String modelChoice = modelChoiceBox.getValue();
            int numberOfSeatsChoice = noOfSeatsSpinner.getValue();
            for (Car car : Database.carsList){
                if (car.getFuelType().equals(fuelTypeChoice) &&
                        car.getNumberOfSeats() >= numberOfSeatsChoice &&
                        car.getModel().equals(modelChoice)
                ) {
                    list.add(car);
                }
            }
        }
        if (vehicleChoice.equals("Van")){
            System.out.println("the vehicle is indeed a van");
            int horsepowerChoice = horsepowerSpinner.getValue();
            int cargoCapacityChoice = cargoCapacitySpinner.getValue();

            for (Van van : Database.vansList){
                if (van.getEngineInHorsePower() >= horsepowerChoice &&
                        van.getCargoCapacity() >= cargoCapacityChoice){
                    list.add(van);
                }
            }
        }
        if (vehicleChoice.equals("Bike")){
            System.out.println("the vehicle is indeed a bike");
            String typeChoice = typeChoiceBox.getValue();

            for (Bike bike : Database.bikesList){
                if (bike.getType().equals(typeChoice)){
                    list.add(bike);
                }
            }
        }
        Database.assignArrayList(list);
        for (Vehicle v : list ){
            System.out.println(v);
        }

        if (!list.isEmpty()){
            System.out.println("The vehicle arraylist is indeed not empty");
            SceneSwitcher.switchTo("/display-vehicle.fxml", "Vehicle Display Scene");
        }
    }
}