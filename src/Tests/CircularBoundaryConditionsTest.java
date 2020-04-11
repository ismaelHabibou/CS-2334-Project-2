package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.CircularBoundaryConditions;
import projects.Generation;
import projects.Cell;

import static org.junit.jupiter.api.Assertions.*;

class CircularBoundaryConditionsTest {
 /** Create an instance of circular boundary conditions*/
    private CircularBoundaryConditions boundaryConditions;

 /** Create a generation*/
    private Generation generation;

    @BeforeEach
    void setUp() {
       String state = "O O O O O O O O O O O O O O O O O ";
       generation = new Generation(state);
       boundaryConditions = new CircularBoundaryConditions();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNeighbor() {
       Cell cellAt2 = generation.getCell(2);
        Cell cellAtIndex = generation.getCell(9);
        Cell cellNegativeIndex = generation.getCell( - 2);

        assertEquals(cellAt2,boundaryConditions.getNeighbor(0, 2,generation)); // check if the cell at 2
        assertEquals(cellAtIndex, boundaryConditions.getNeighbor(0,generation.size() + 9,generation)); // check the cell at index
        assertEquals(cellNegativeIndex, boundaryConditions.getNeighbor(0, (-2),generation)); // check a negative cell
    }
}