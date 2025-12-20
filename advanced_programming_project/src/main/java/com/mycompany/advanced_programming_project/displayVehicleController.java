package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.List;

public class displayVehicleController {

    @FXML private Label lblManufacture, lblModel, lblRent, lblNumberOfSeats, lblAvailable, lblYear, lblFuel, lblEngine;
    @FXML private ImageView carImage;
    @FXML private Button backButton, nextButton, returnButton;

    private List<Vehicle> vehicleList;
    private int currentIndex = 0;

    @FXML
    private void initialize() {
        this.vehicleList = Database.vehicleArrayList;

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
            Database.currentVehicle = vehicleList.get(currentIndex);
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
        // Assuming public fields or getters exist as per original code.
        // Ideally, use getters (e.g., v.getManufacturer()) if available.
        lblManufacture.setText(v.manufacturer);
        lblModel.setText("(" + v.getModel() + ")");
        lblYear.setText(String.valueOf(v.year));
        lblRent.setText(v.rentalRatePerDay + "$/Day");
        lblAvailable.setText("Available: " + v.numberAvailable);

        if (v instanceof Car) {
            Car c = (Car) v;
            lblNumberOfSeats.setText("Seats: " + c.getNumberOfSeats());
            lblFuel.setText("Fuel: " + c.getFuelType());
            lblEngine.setText("Type: Car");
        } else if (v instanceof Van) {
            Van van = (Van) v;
            lblNumberOfSeats.setText("Cargo: " + van.getCargoCapacity() + "kg");
            lblFuel.setText("Type: Van");
            lblEngine.setText("HP: " + van.getEngineInHorsePower());
        } else if (v instanceof Bike) {
            lblNumberOfSeats.setText("N/A");
            lblFuel.setText("Type: Bike");
            lblEngine.setText("N/A");
        }

        if (v.imageFilePath != null && !v.imageFilePath.isEmpty()) {
            try {
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

    @FXML
    private void handleBookNowButton(ActionEvent event) {
        if (vehicleList != null && !vehicleList.isEmpty()) {
            Database.currentVehicle = vehicleList.get(currentIndex);
        }
        // Assuming Booking constructor is valid
        Booking booking = new Booking("0", "Pending", Database.currentUser, Database.currentVehicle, 0, null);
        Database.currentBooking = booking;
        SceneSwitcher.switchTo("/payment.fxml", "The Payment scene");
    }
}