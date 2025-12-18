package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent; // CRITICAL: Use javafx, NOT java.awt
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class displayVehicleController {

    public Button returnButton;
    @FXML private Label lblManufacture, lblModel, lblRent, lblNumberOfSeats, lblAvailable, lblYear, lblFuel, lblEngine;
    @FXML private ImageView carImage;
    @FXML private Button backButton, nextButton; // Must be Button

    private List<Vehicle> vehicleList;
    private int currentIndex = 0;

    @FXML
    private void initialize() {
        // 1. Load the list that was assigned in chooseVehicleController
        this.vehicleList = Database.vehicleArrayList;

        // 2. IMMEDIATELY show the first car
        if (vehicleList != null && !vehicleList.isEmpty()) {
            displayVehicle(vehicleList.get(currentIndex));
        } else {
            System.out.println("Warning: No vehicles found in the list!");
        }
        updateButtonVisibility();
    }

    @FXML
    private void handleNextButton(ActionEvent event) {
        if (currentIndex < vehicleList.size() - 1) {
            currentIndex++;
            displayVehicle(vehicleList.get(currentIndex));
            updateButtonVisibility();
        }
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        if (currentIndex > 0) {
            currentIndex--;
            displayVehicle(vehicleList.get(currentIndex));
            updateButtonVisibility();
        }
    }

    private void displayVehicle(Vehicle v) {
        System.out.println("The vehicle will be displayed");
        // Update basic labels
        lblManufacture.setText(v.manufacturer);
        lblModel.setText("(" + v.getModel() + ")");
        lblYear.setText(String.valueOf(v.year));
        lblRent.setText(v.rentalRatePerDay+"$/Day" );
        lblAvailable.setText("Available: " + v.numberAvailable);

        // Update labels based on vehicle type
        if (v instanceof Car) {
            System.out.println("The vehicle is a car");
            Car c = (Car) v;
            lblNumberOfSeats.setText("Seats: " + c.getNumberOfSeats());
            lblFuel.setText("Fuel: " + c.getFuelType());
            lblEngine.setText("Type: Car");
        } else if (v instanceof Van) {
            System.out.println("the vehicle is a van");
            Van van = (Van) v;
            lblNumberOfSeats.setText("Cargo: " + van.getCargoCapacity() + "kg");
            lblFuel.setText("Type: Van");
            lblEngine.setText("HP: " + van.getEngineInHorsePower());
        }

        // Update Image
        if (v.imageFilePath != null && !v.imageFilePath.isEmpty()) {
            try {
                // Ensure image is in src/main/resources/com/mycompany/advanced_programming_project/images/
                Image img = new Image(getClass().getResourceAsStream(v.imageFilePath));
                carImage.setImage(img);
            } catch (Exception e) {
                System.out.println("Error loading image: " + v.imageFilePath);
            }
        }
    }

    private void updateButtonVisibility() {
        backButton.setDisable(currentIndex == 0);
        nextButton.setDisable(vehicleList == null || currentIndex == vehicleList.size() - 1);
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        SceneSwitcher.switchTo("/choose-vehicle.fxml", "The Choose Vehicle Scene");
    }
}