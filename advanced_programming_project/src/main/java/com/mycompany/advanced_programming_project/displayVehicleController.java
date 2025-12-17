package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class displayVehicleController {

    // Matches FXML fx:id exactly
    @FXML private Label lblManufacture;
    @FXML private Label lblModel;
    @FXML private Label lblRent;
    @FXML private Label lblSeats; // Changed from lblNumberOfSeats to match this variable
    @FXML private Label lblYear;
    @FXML private Label lblFuel;
    @FXML private Label lblAvailable;
    @FXML private ImageView carImage;

    // These MUST be Buttons in Java if they are Buttons in FXML
    @FXML private Button backButton;
    @FXML private Button nextButton;

    private List<Vehicle> vehicleList;
    private int currentIndex = 0;

    @FXML
    private void initialize() {
        // 1. Get the FILTERED list from your data class
        // Make sure VehicleArrayList has a static 'filteredList' or similar
        this.vehicleList = VehicleArrayList.getFilteredList();

        if (vehicleList != null && !vehicleList.isEmpty()) {
            displayVehicle(vehicleList.get(currentIndex));
        }
        updateButtonVisibility();
    }

    @FXML
    private void handleNextButton(ActionEvent event) {
        if (currentIndex < vehicleList.size() - 1) {
            currentIndex++;
            displayVehicle(vehicleList.get(currentIndex));
        }
        updateButtonVisibility();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        if (currentIndex > 0) {
            currentIndex--;
            displayVehicle(vehicleList.get(currentIndex));
        }
        updateButtonVisibility();
    }

    private void displayVehicle(Vehicle v) {
        // Shared fields (Vehicle class)
        lblManufacture.setText(v.manufacturer);
        lblModel.setText("(" + v.getModel() + ")");
        lblYear.setText(String.valueOf(v.year));
        lblRent.setText("rent/day: $" + v.rentalRatePerDay);
        lblAvailable.setText("number available: " + v.numberAvailable);

        // Specific fields based on type
        if (v instanceof Car) {
            Car c = (Car) v;
            lblSeats.setText("-seats: " + c.getNumberOfSeats());
            lblFuel.setText("-fuel: " + c.getFuelType());
        } else if (v instanceof Van) {
            Van van = (Van) v;
            lblSeats.setText("-cargo: " + van.getCargoCapacity() + "kg");
            lblFuel.setText("-HP: " + van.getEngineInHorsePower());
        }

        // Update the image
        try {
            if (v.imageFilePath != null) {
                Image img = new Image(getClass().getResourceAsStream(v.imageFilePath));
                carImage.setImage(img);
            }
        } catch (Exception e) {
            System.out.println("Image error: " + v.imageFilePath);
        }
    }

    private void updateButtonVisibility() {
        backButton.setDisable(currentIndex == 0);
        nextButton.setDisable(vehicleList == null || currentIndex == vehicleList.size() - 1);
    }
}