package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;


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
        VehicleArrayList.generateData();
        myChoiceBox.getItems().addAll("Car", "Van","Bike");
        myChoiceBox.setValue("select a vehicle");
        fuelType_EngineInHorsePower_typeLabel.setVisible(false);

        model_cargoCapacity_nullLabel.setVisible(false);

        numberOfSeats_null_nullLabel.setVisible(false);

        fuelType_EngineInHorsePower_typeTextField.setVisible(false);

        fuelTypeChoiceBox.setVisible(false);
        fuelTypeChoiceBox.getItems().addAll("Petrol","Diesel","Electric");

        horsepowerSpinner.setVisible(false);
        SpinnerValueFactory<Integer> hpFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(70,350,130,5);
        horsepowerSpinner.setValueFactory(hpFactory);
        horsepowerSpinner.setEditable(true);

        typeChoiceBox.setVisible(false);
        typeChoiceBox.getItems().addAll("Motor Bike","Motor Skooter","Racing Motor Bike");

        model_cargoCapacity_nullTextField.setVisible(false);

        modelChoiceBox.setVisible(false);
        modelChoiceBox.getItems().addAll("SUV", "Sedan", "Hatchback", "Coupe");

        cargoCapacitySpinner.setVisible(false);
        SpinnerValueFactory<Integer> cargoFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 5000, 500, 50);
        cargoCapacitySpinner.setValueFactory(cargoFactory);
        cargoCapacitySpinner.setEditable(true);

        cargoCapacityLabel.setVisible(false);
        numberOfSeats_null_nullTextField.setVisible(false);
        noOfSeatsSpinner.setVisible(false);
        SpinnerValueFactory<Integer> seatsFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 6, 4, 1);
        noOfSeatsSpinner.setValueFactory(seatsFactory);
        cargoCapacitySpinner.setEditable(true);

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

        // <--- 1. Add this so FXML can find it

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
            for (Car car : VehicleArrayList.carsList){
                System.out.println("iterating through the cars");
                if (car.getFuelType().equals(fuelTypeChoice) &&
                        car.getNumberOfSeats() >= numberOfSeatsChoice &&
                        car.getModel().equals(modelChoice)
                ) {
                    System.out.println("the fuel is: " + car.getFuelType() + " The number of seats is " + car.getNumberOfSeats() + " the model is " + car.getModel());
                    list.add(car);
                    System.out.println("added a car");
                }


                }}
        if (vehicleChoice.equals("Van")){
            System.out.println("the vehicle is indeed a van");
            int horsepowerChoice = horsepowerSpinner.getValue();
            int cargoCapacityChoice = cargoCapacitySpinner.getValue();

            for (Van van : VehicleArrayList.vansList){
                System.out.println("iterating through the vans");


                if (van.getEngineInHorsePower() >= horsepowerChoice &&
                        van.getCargoCapacity() >= cargoCapacityChoice){
                    list.add(van);
                    System.out.println("added a van");

                }

            }
        }
        if (vehicleChoice.equals("Bike")){
            System.out.println("the vehicle is indeed a bike");
            String typeChoice = typeChoiceBox.getValue();

            for (Bike bike : VehicleArrayList.bikesList){
                System.out.println("iterating through the bikes");
                if (bike.getType().equals(typeChoice)){
                    list.add(bike);
                    System.out.println("added a bike");

                }
            }
        }
        VehicleArrayList.assignArrayList(list);
        for (Vehicle v : list ){
            System.out.println(v);
        }

        if (!list.isEmpty()){
            System.out.println("The vehicle arraylist is indeed not empty");
            SceneSwitcher.switchTo("/display-vehicle.fxml", "Vehicle Display Scene");
        }


    }

}
