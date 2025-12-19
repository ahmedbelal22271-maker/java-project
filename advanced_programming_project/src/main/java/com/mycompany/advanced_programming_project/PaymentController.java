package com.mycompany.advanced_programming_project;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

public class PaymentController {
    public ImageView vehicleImageView;
    public ToggleGroup paymentGroup;
    public TextField creditCardTextField;
    public Spinner<Integer> noOfDaysSpinner;
    public Label totalAmountLabel;
    public Label emailLabel;
    public Label phoneNumberLabel;
    public Button confirmButton;
    public RadioButton creditCardRadioButton;
    public RadioButton cashRadioButton;

    @FXML
    public void initialize(){

        setupSafeSpinner(noOfDaysSpinner, 1, 30, 1, 1);

        Vehicle vehicle = Database.currentVehicle;

        if (vehicle.imageFilePath != null && !vehicle.imageFilePath.isEmpty()) {
            try {
                Image img = new Image(getClass().getResourceAsStream(vehicle.imageFilePath));
                vehicleImageView.setImage(img);
            } catch (Exception e) {
                System.out.println("Error loading image: " + vehicle.imageFilePath);
            }
        }

        paymentGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            if (newVal != null){
                RadioButton selected = (RadioButton) newVal;


            }
        });




    }



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

}
