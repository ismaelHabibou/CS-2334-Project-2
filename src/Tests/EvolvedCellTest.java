package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.CellState;
import projects.EvolvedCell;

import static org.junit.jupiter.api.Assertions.*;

class EvolvedCellTest {
    EvolvedCell cell;
    private int ruleNumber = (int)(Math.random() * 10);

    @BeforeEach
    void setUp() {
        cell = new EvolvedCell(CellState.ON,ruleNumber);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSubruleNum() {
        assertEquals(ruleNumber,cell.getSubruleNum());
    }
}