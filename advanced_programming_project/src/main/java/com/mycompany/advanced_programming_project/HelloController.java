package com.mycompany.advanced_programming_project;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;

public class HelloController {
    // 1. Declare the ChoiceBox (Name must match the fx:id you just typed!)
    @FXML
    private ChoiceBox<String> myChoiceBox;

    // 2. Initialize the data (Runs automatically when the app starts)
    @FXML
    public void initialize() {
        myChoiceBox.getItems().addAll("Car", "Van", "Bike");
        myChoiceBox.setValue("Choose a Vehicle"); // Sets a default selected value
    }
}
