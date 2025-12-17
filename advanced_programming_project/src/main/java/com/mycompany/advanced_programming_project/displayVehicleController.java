package com.mycompany.advanced_programming_project;
import com.sun.javafx.menu.MenuItemBase;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;

import java.awt.event.ActionEvent;
import java.util.List;

public class displayVehicleController {
    // These names must match the fx:id in your FXML exactly
    @FXML private Label lblManufacture;
    @FXML private Label lblModel;
    @FXML private Label lblRent;
    @FXML private Label lblSeats;
    @FXML private ImageView carImage;
    @FXML private Label lblAvailable;
    @FXML private Label lblYear;
    @FXML private Label lblFuel;
    @FXML private Label backButton;
    @FXML private Label nextButton;
    private List<Car> carList; // Your existing Car data class
    private int currentIndex = 0;




    public class DisplayVehicleController {
        // ... your FXML @FXML labels ...

        private Vehicle selectedVehicle;

        // This method will be called by the PREVIOUS controller
        public void setVehicleData(Vehicle vehicle) {
            this.selectedVehicle = vehicle;

            // Update the labels immediately
            lblManufacture.setText(vehicle.manufacturer);
            lblModel.setText("(" + vehicle.getModel() + ")");
            // ... update all other labels like you did before ...
        }
    }





    @FXML
    public void handleNextButton() {
        if (carList != null && currentIndex < carList.size() - 1) {
            currentIndex++;
            displayCar(carList.get(currentIndex));
        }
    }

    // Method to update all labels at once
    private void displaycar(Car car) {
        lblManufacture.setText(car.manufacturer);
        lblModel.setText("(" + car.getModel() + ")");
        lblRent.setText("rent/day: $" + car.rentalRatePerDay);
        lblSeats.setText("-number of seats: " + car.numberOfSeats);

        // Update image (assumes car.getImagePath() returns a valid path/URL)
        Image img = new Image(car.imageFilePath);
        carImage.setImage(img);
    }
    private void updateButtonVisibility() {
        // Disable BACK if at the start
        backButton.setDisable(currentIndex == 0);

        // Disable NEXT if at the end
        nextButton.setDisable(currentIndex == carList.size() - 1);
    }

    @FXML
    private void initialize() {
        // 1. Load your data (from a database, file, or hardcoded list)
        carList = VehicleArrayList.carsList;

        // 2. Display the first car if the list isn't empty
        if (!carList.isEmpty()) {

        }


        // 3. Update button states (optional but recommended)
        updateButtonVisibility();
    }


    @FXML
    private void handleNextButton(ActionEvent event) {
        // Check if we can go forward
        if (currentIndex < carList.size() - 1) {
            currentIndex++;
            displayCar(carList.get(currentIndex));
        }
        updateButtonVisibility();
    }

    @FXML
    private void handleBackButton(ActionEvent event) {
        // Check if we can go backward
        if (currentIndex > 0) {
            currentIndex--;
            displayCar(carList.get(currentIndex));
        }
        updateButtonVisibility();
    }
    private void displayCar(Car car) {
        lblManufacture.setText(car.manufacturer);
        lblModel.setText("(" + car.getModel() + ")");

        lblYear.setText(String.valueOf(car.year));
        lblSeats.setText("-number of seats: " + car.numberOfSeats);

        lblFuel.setText("-fuel type: " + car.getFuelType());
        lblRent.setText("rent/day: $" + car.rentalRatePerDay);

        lblAvailable.setText("number available: " + car.numberAvailable);

        // Update the image
        try {
            Image img = new Image(getClass().getResourceAsStream(car.imageFilePath));
            carImage.setImage(img);
        } catch (Exception e) {
            System.out.println("Image not found: " + car.imageFilePath);
        }
    }

}
