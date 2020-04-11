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

       boundaryConditions = new CircularBoundaryConditions();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNeighbor() {
int index = generation.size() / 2;
        Cell cellAt2 = generation.getCell(2);
        Cell cellAtIndex = generation.getCell(index);
        Cell cellNegativeIndex = generation.getCell(3);

        assertEquals(cellAt2,boundaryConditions.getNeighbor(index, (index + 2),generation)); // check if the cell at 2
        assertEquals(cellAtIndex, boundaryConditions.getNeighbor(index,index,generation)); // check the cell at index
        assertEquals(cellNegativeIndex, boundaryConditions.getNeighbor(index, (-index - 3),generation)); // check a negative cell
    }
}