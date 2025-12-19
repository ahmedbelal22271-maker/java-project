package com.mycompany.advanced_programming_project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;

import javax.xml.crypto.Data;


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
    public Payment payment;
    public String paymentMethod = "null";
    public Label nameLabel;
    public Label licenseLabel;
    public Button returnButton;
    public Label invalidCreditCardLabel;
    public Label paymentSuccessfulLabel;
    public Label provideAMethodLabel;
    public Label chooseTheNoOfDaysLabel;


    @FXML
    public void initialize(){
        chooseTheNoOfDaysLabel.setVisible(false);
        creditCardTextField.setVisible(false);
        totalAmountLabel.setVisible(true);
        totalAmountLabel.setText("" + Database.currentVehicle.getRentalRatePerDay());
        invalidCreditCardLabel.setVisible(false);
        paymentSuccessfulLabel.setVisible(false);
        provideAMethodLabel.setVisible(false);

        Database.generateCreditCardNumbers();
        setupSafeSpinner(noOfDaysSpinner, 1, 30, 1, 1);

        User user = Database.currentUser;

        emailLabel.setText(user.getEmail());
        phoneNumberLabel.setText(user.getPhoneNumber());
        nameLabel.setText(user.getName());
        licenseLabel.setText(user.getLicenseNumber());

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
            provideAMethodLabel.setVisible(false);
            if (newVal != null){
                RadioButton selected = (RadioButton) newVal;
                paymentMethod = selected.getText();
                if (selected == cashRadioButton){
                    creditCardTextField.setVisible(false);
                }
                else{
                    creditCardTextField.setVisible(true);
                }
            }
        });

        // Add a listener to the VALUE property
        noOfDaysSpinner.valueProperty().addListener((observable, oldValue, newValue) -> {

            // 1. Check if the new value is valid (not null)
            if (newValue != null) {
                totalAmountLabel.setVisible(true);

                // 2. Perform your calculation
                // Example: Calculate Total Cost = Days * Rent Per Day
                double rentPerDay = Database.currentVehicle.rentalRatePerDay; // Get current price
                double totalCost = newValue * rentPerDay;

                // 3. Update the Label
                totalAmountLabel.setText(""+totalCost);
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

    @FXML
    private void handlePaymentSubmitButton(ActionEvent event) {
        if (!paymentMethod.equals("null")){
            provideAMethodLabel.setVisible(false);
            if (paymentMethod.equals("credit card")) {
                boolean validCreditCard = false;
                String writtenCreditCard = creditCardTextField.getText();
                for (String card : Database.creditCardNumbers){
                    if (writtenCreditCard.equals(card)) {
                        validCreditCard = true;
                        break;
                    }

                }
                if (!validCreditCard){
                    invalidCreditCardLabel.setVisible(true);
                    paymentSuccessfulLabel.setVisible(false);
                }
                else{
                    invalidCreditCardLabel.setVisible(false);
                    paymentSuccessfulLabel.setVisible(true);
                }



            }
            else{
                invalidCreditCardLabel.setVisible(false);
                paymentSuccessfulLabel.setVisible(true);
            }




            payment = new Payment((double) Double.parseDouble(totalAmountLabel.getText()),
                    Database.currentBooking,
                    paymentMethod
            );

        }
        else{
            provideAMethodLabel.setVisible(true);
        }

        if (noOfDaysSpinner.getValue() == 0){
            chooseTheNoOfDaysLabel.setVisible(true);
        }
        else{
            chooseTheNoOfDaysLabel.setVisible(false);
        }


    }

    @FXML
    private void handleReturnButton(ActionEvent event) {
        SceneSwitcher.switchTo("/display-vehicle.fxml", "Display Vehicle Scene");
    }


}
