package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import javax.xml.crypto.Data;
import java.util.List;

public class displayVehicleController {

    public Button returnButton;

    @FXML private Label lblManufacture, lblModel, lblRent, lblNumberOfSeats, lblAvailable, lblYear, lblFuel, lblEngine;
    @FXML private ImageView carImage;
    @FXML private Button backButton, nextButton;

    private List<Vehicle> vehicleList;
    private int currentIndex = 0;

    @FXML
    private void initialize() {
        // --- SETUP SPINNER WITH RANGE CHECKS ---
        // Min: 1, Max: 30, Initial: 1
        // Logic:
        //   - If user types "0" or "-5", it jumps to 1.
        //   - If user types "100", it jumps to 30.
        //   - If user types "abc", it jumps to 1.

        this.vehicleList = Database.vehicleArrayList;

        if (vehicleList != null && !vehicleList.isEmpty()) {
            displayVehicle(vehicleList.get(currentIndex));
        } else {
            System.out.println("Warning: No vehicles found in the list!");
        }
        updateButtonVisibility();
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
                    if (string == null || string.trim().isEmpty()) {
                        return min;
                    }

                    int value = Integer.parseInt(string);

                    // --- NEW: RANGE VALIDATION LOGIC ---
                    if (value < min) {
                        System.out.println("Input " + value + " is too low. Clamping to min: " + min);
                        return min;
                    } else if (value > max) {
                        System.out.println("Input " + value + " is too high. Clamping to max: " + max);
                        return max;
                    }

                    return value;

                } catch (NumberFormatException e) {
                    System.out.println("Invalid type '" + string + "'. Resetting to min: " + min);
                    return min;
                }
            }
        };

        factory.setConverter(safeConverter);
        spinner.setValueFactory(factory);
        spinner.setEditable(true);
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
            // Added minimal check for Bike to avoid bugs if you view a bike
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
    private void handleBookNowButton(ActionEvent event){
        if (vehicleList != null && !vehicleList.isEmpty()) {
            Database.currentVehicle = vehicleList.get(currentIndex);
        }
        Booking booking = new Booking("0",
                "Pending",
                Database.currentUser,
                Database.currentVehicle,
                0,
                null
                );
        Database.currentBooking = booking;
        SceneSwitcher.switchTo("/payment.fxml", "The Payment scene");
    }
}