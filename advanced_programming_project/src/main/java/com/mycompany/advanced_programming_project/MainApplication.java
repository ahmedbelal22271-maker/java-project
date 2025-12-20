package com.mycompany.advanced_programming_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        SceneSwitcher.setStage(stage);


        // 1. THIS IS THE LINE THAT LOADS THE FILE
        SceneSwitcher.switchTo("/login-view.fxml", "Login page");
    }

    // Standard main method required for most IDEs/systems
    public static void main(String[] args) {
        launch(args);
    }
}