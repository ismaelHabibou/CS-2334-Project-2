package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.CellState;
import projects.FixedBoundaryConditions;
import projects.Generation;
import projects.Cell;

import static org.junit.jupiter.api.Assertions.*;

class FixedBoundaryConditionsTest {
 /** declare two CellStates*/
    CellState leftState;
    CellState rightState;
    Generation generation;

    /** declare  a fixed boundary conditions*/
    FixedBoundaryConditions boundaryConditions;

    @BeforeEach
    void setUp() {
        String states = "O O O O O O O O O O O O O O O O O O O O";
        leftState = CellState.OFF;
        rightState = CellState.ON;
        generation = new Generation(states);

        boundaryConditions = new FixedBoundaryConditions(leftState, rightState);
    }

    @AfterEach
    void tearDown() {
        leftState = null;
        rightState = null;
        generation = null;
        boundaryConditions = null;
    }

    @Test
    void getLeftState() {
        assertEquals(leftState.toString(),boundaryConditions.getLeftState().toString());
    }

    @Test
    void getRightState() {
       assertEquals(rightState.toString(), boundaryConditions.getRightState().toString());
    }

    @Test
    void getNeighbor() {
        Cell leftBoundary = new Cell(leftState);
        Cell rightBoundary = new Cell(rightState);
        int index = 5;
        Cell inBetween = new Cell(generation.getCell(index).getState());

        assertSame(leftBoundary.getState(),boundaryConditions.getNeighbor(0,-2,generation).getState());
        assertSame(rightBoundary.getState(), boundaryConditions.getNeighbor(0,generation.size(),generation).getState());
        assertSame(inBetween.getState(),boundaryConditions.getNeighbor(0,index,generation).getState());
    }
}