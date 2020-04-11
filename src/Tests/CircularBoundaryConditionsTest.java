package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.CircularBoundaryConditions;
import projects.Generation;

import static org.junit.jupiter.api.Assertions.*;

class CircularBoundaryConditionsTest {
 /** Create an instance of circular boundary conditions*/
    private CircularBoundaryConditions boundaryConditions;

 /** Create a generation*/
    private Generation generation;

    @BeforeEach
    void setUp() {
       String state = "O O O O O O O O O O O O O O O O O ";

       boundaryConditions = new CircularBoundaryConditions();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNeighbor() {
    }
}