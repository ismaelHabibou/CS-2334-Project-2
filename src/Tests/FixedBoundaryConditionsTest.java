package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.CellState;
import projects.FixedBoundaryConditions;

import static org.junit.jupiter.api.Assertions.*;

class FixedBoundaryConditionsTest {
 /** declare two CellStates*/
    CellState leftState;
    CellState rightState;

    /** declare  a fixed boundary conditions*/
    FixedBoundaryConditions boundaryConditions;

    @BeforeEach
    void setUp() {
        leftState = CellState.OFF;
        rightState = CellState.ON;

        boundaryConditions = new FixedBoundaryConditions(leftState, rightState);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getLeftState() {
        assertEquals(leftState.toString(),boundaryConditions.getLeftState().toString());
    }

    @Test
    void getRightState() {
    }

    @Test
    void getNeighbor() {
    }
}