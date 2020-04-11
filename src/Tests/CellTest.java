package Tests;

import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.Cell;
import projects.CellState;

import static org.junit.jupiter.api.Assertions.*;

/** Test for the Cell class.*/
class CellTest {
   private Cell firstCell;

    @BeforeEach
    public void setUp() {
        firstCell = new Cell(CellState.ON);
    }

    @AfterEach
    public void tearDown() {
        firstCell = null;
    }

    @Test
    public void getState() {
        assertSame(firstCell.getState(), CellState.ON);

    }

    @Test
    public void testToString(){
        assertEquals(firstCell.toString(),CellState.ON.toString());
    }


}