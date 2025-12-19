package com.mycompany.advanced_programming_project;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CarTest {

    @Test
    void testCarBasics() {
        // Create a Car
        Car car = new Car(
                "Toyota",     // manufacturer
                "SUV",        // model
                5,            // numberAvailable
                100.0f,       // rentalRatePerDay
                2023,         // year
                "Petrol",     // fuelType
                6             // numberOfSeats
        );

        // Test getters that exist
        assertEquals("Petrol", car.getFuelType());
        assertEquals(6, car.getNumberOfSeats());
        assertEquals("SUV", car.getModel()); // from Vehicle
    }

    @Test
    void testImagePath() {
        // Create a Car
        Car car = new Car(
                "Tesla",
                "Sedan",
                3,
                200.0f,
                2024,
                "Electric",
                4
        );

        // Test if image is loaded correctly
        assertEquals("/images/electric_car.jpeg", car.imageFilePath);
    }
}

