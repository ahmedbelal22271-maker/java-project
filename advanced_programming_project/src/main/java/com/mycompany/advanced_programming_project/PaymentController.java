package com.mycompany.advanced_programming_project;

import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.util.StringConverter;

public class PaymentController {
    public Spinner<Integer> NoOfDaysSpinner;

    @FXML
    public void initialize(){

        setupSafeSpinner(NoOfDaysSpinner, 1, 30, 1, 1);
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
