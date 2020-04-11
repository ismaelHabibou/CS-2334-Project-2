package Tests;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import projects.CellState;

import static org.junit.jupiter.api.Assertions.*;

public class CellStateTest {
    /** Create two cell states*/
    CellState on = CellState.ON;
    CellState off = CellState.OFF;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

   @Test
   public void getState() {
        char onSymbol = 'O';
        char offSymbol = ' ';

        assertSame(CellState.getState(onSymbol), on);
        assertSame(CellState.getState(offSymbol), off);
    }

    @Test
    public void testToString() {
        String on = "O";
        String off = " ";
        assertEquals(on, this.on.toString());
        assertEquals(off,this.off.toString());
    }
}