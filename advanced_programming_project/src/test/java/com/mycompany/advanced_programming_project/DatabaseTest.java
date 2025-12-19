package com.mycompany.advanced_programming_project;

import java.lang.annotation.Repeatable;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {

    @Test
    @DisplayName("Check that each list is not empty")
    void testGenerateDataListsFilled() {
        // Generate random data
        Database.generateData();

        // Check that each list is not empty
        assertFalse(Database.carsList.isEmpty(), "Cars list should not be empty");
        assertFalse(Database.vansList.isEmpty(), "Vans list should not be empty");
        assertFalse(Database.bikesList.isEmpty(), "Bikes list should not be empty");
    }

    @Test
    @DisplayName("Check values assigned correctly")
    void testCarValues() {
        Database.generateData();

        // Take the first car
        Car car = Database.carsList.get(0);
        assertNotNull(car.getModel(), "Model should not be null");
        assertTrue(car.getNumberOfSeats() == 2 || car.getNumberOfSeats() == 4 || car.getNumberOfSeats() == 6,
                "Number of seats should be 2, 4, or 6");

        // Check basic logic
        if (car.getModel().equals("Coupe")) {
            assertEquals(2, car.getNumberOfSeats(), "Coupe must have 2 seats");
        }
        if (car.getModel().equals("SUV")) {
            assertTrue(car.getNumberOfSeats() == 4 || car.getNumberOfSeats() == 6,
                    "SUV must have 4 or 6 seats");
        }
    }

     @Test
     @DisplayName(" Simple check NonNull Model")       
    void testBikeValues() {
        Database.generateData();

        Bike bike = Database.bikesList.get(0);

        // Simple check
        assertNotNull(bike.getModel(), "Bike model should not be null");
    }
}
