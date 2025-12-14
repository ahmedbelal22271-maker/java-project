package com.mycompany.advanced_programming_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        // 1. THIS IS THE LINE THAT LOADS THE FILE
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("/choose-vehicle.fxml"));

        // 2. This puts the loaded file into the window
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    // Standard main method required for most IDEs/systems
    public static void main(String[] args) {
        launch(args);
    }
}