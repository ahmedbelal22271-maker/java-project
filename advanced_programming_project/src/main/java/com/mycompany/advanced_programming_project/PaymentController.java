package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

public class PaymentController {

    @FXML private ImageView vehicleImageView;
    @FXML private ToggleGroup paymentGroup;
    @FXML private TextField creditCardTextField;
    @FXML private Spinner<Integer> noOfDaysSpinner;
    @FXML private Button confirmButton, returnButton;
    @FXML private RadioButton creditCardRadioButton, cashRadioButton;
    @FXML private Label totalAmountLabel, emailLabel, phoneNumberLabel, nameLabel, licenseLabel,
            invalidCreditCardLabel, paymentSuccessfulLabel, provideAMethodLabel, chooseTheNoOfDaysLabel;

    private Payment payment;
    private String paymentMethod = null;

    @FXML
    private void initialize() {
        // 1. Initial Visibility Setup
        setVisible(false, chooseTheNoOfDaysLabel, creditCardTextField, invalidCreditCardLabel,
                paymentSuccessfulLabel, provideAMethodLabel);
        totalAmountLabel.setVisible(true);

        // 2. Load User and Vehicle Data
        User user = Database.currentUser;
        Vehicle vehicle = Database.currentVehicle;
        Database.generateCreditCardNumbers();

        emailLabel.setText(user.getEmail());
        phoneNumberLabel.setText(user.getPhoneNumber());
        nameLabel.setText(user.getName());
        licenseLabel.setText(user.getLicenseNumber());

        // Set initial price based on data
        totalAmountLabel.setText(String.valueOf(vehicle.getRentalRatePerDay()));

        // 3. Setup Image
        if (vehicle.imageFilePath != null && !vehicle.imageFilePath.isEmpty()) {
            try {
                vehicleImageView.setImage(new Image(getClass().getResourceAsStream(vehicle.imageFilePath)));
            } catch (Exception e) {
                System.out.println("Error loading image: " + vehicle.imageFilePath);
            }
        }

        // 4. Setup Spinner
        setupSafeSpinner(noOfDaysSpinner, 1, 30, 1, 1);

        // 5. Listeners
        paymentGroup.selectedToggleProperty().addListener((observable, oldVal, newVal) -> {
            provideAMethodLabel.setVisible(false);
            if (newVal != null) {
                RadioButton selected = (RadioButton) newVal;
                paymentMethod = selected.getText();
                creditCardTextField.setVisible(selected == creditCardRadioButton);
            }
        });

        noOfDaysSpinner.valueProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                double totalCost = newVal * Database.currentVehicle.getRentalRatePerDay();
                totalAmountLabel.setText(String.valueOf(totalCost));
            }
        });
    }

    @FXML
    private void handlePaymentSubmitButton(ActionEvent event) {
        // Reset Error Labels
        setVisible(false, chooseTheNoOfDaysLabel, provideAMethodLabel, invalidCreditCardLabel, paymentSuccessfulLabel);

        // --- VALIDATION STEP 1: CHECK SPINNER VALIDITY ---
        int days;
        try {
            // Get the raw text from the spinner editor to check what the user actually typed
            String spinnerText = noOfDaysSpinner.getEditor().getText();

            // Check if empty
            if (spinnerText == null || spinnerText.trim().isEmpty()) {
                chooseTheNoOfDaysLabel.setVisible(true);
                return;
            }

            // Try parsing
            days = Integer.parseInt(spinnerText);

            // Check Range (Min 1, Max 30)
            if (days < 1 || days > 30) {
                System.out.println("Invalid days range: " + days);
                chooseTheNoOfDaysLabel.setVisible(true);
                return;
            }

            // Sync the factory value with the valid parsed days (just in case)
            noOfDaysSpinner.getValueFactory().setValue(days);

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format in spinner");
            chooseTheNoOfDaysLabel.setVisible(true);
            return;
        }

        // --- VALIDATION STEP 2: PAYMENT METHOD ---
        if (paymentMethod == null) {
            provideAMethodLabel.setVisible(true);
            return;
        }

        // --- VALIDATION STEP 3: CREDIT CARD ---
        if (paymentGroup.getSelectedToggle() == creditCardRadioButton) {
            String writtenCreditCard = creditCardTextField.getText();
            boolean validCreditCard = Database.creditCardNumbers.contains(writtenCreditCard);

            if (!validCreditCard) {
                invalidCreditCardLabel.setVisible(true);
                return;
            }
        }

        // --- PROCESS PAYMENT ---
        paymentSuccessfulLabel.setVisible(true);
        double finalAmount = days * Database.currentVehicle.getRentalRatePerDay();

        payment = new Payment(
                finalAmount,
                Database.currentBooking,
                paymentMethod
        );

        System.out.println("Payment Processed: " + finalAmount);
    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        SceneSwitcher.switchTo("/display-vehicle.fxml", "Display Vehicle Scene");
    }

    private void setVisible(boolean visible, Control... controls) {
        for (Control c : controls) {
            if (c != null) c.setVisible(visible);
        }
    }

    private void setupSafeSpinner(Spinner<Integer> spinner, int min, int max, int initial, int step) {
        SpinnerValueFactory.IntegerSpinnerValueFactory factory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(min, max, initial, step);

        factory.setConverter(new StringConverter<Integer>() {
            @Override
            public String toString(Integer object) { return object.toString(); }

            @Override
            public Integer fromString(String string) {
                try {
                    if (string == null || string.trim().isEmpty()) return min;
                    int value = Integer.parseInt(string);
                    if (value < min) return min;
                    if (value > max) return max;
                    return value;
                } catch (NumberFormatException e) {
                    return min;
                }
            }
        });
        spinner.setValueFactory(factory);
        spinner.setEditable(true);
    }
}