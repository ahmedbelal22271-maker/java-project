package com.mycompany.advanced_programming_project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneSwitcher {

    private static Stage stage;

    // Call this ONCE in your MainApplication to save the window
    public static void setStage(Stage currentStage) {
        stage = currentStage;
    }

    // Call this whenever you want to switch scenes
    public static void switchTo(String fxmlFileName, String title) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(SceneSwitcher.class.getResource(fxmlFileName));
            Scene scene = new Scene(fxmlLoader.load());
            stage.setTitle(title);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error loading FXML file: " + fxmlFileName);
        }
    }
}