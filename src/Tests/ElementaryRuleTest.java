package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.*;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryRuleTest {
    private int ruleNumber = 22;
    /** Create an elementary rule object*/
    Rule rule = new ElementaryRule(ruleNumber);

    /** Create a generation for the rule*/
    Generation generation ;

    /** Create boundary conditions*/
    BoundaryConditions circular = new CircularBoundaryConditions();

    /** Create a fixed boundary conditions*/
    BoundaryConditions fixed = new FixedBoundaryConditions(CellState.OFF,CellState.ON);

    @BeforeEach
    void setUp() {
        String states = "O O O O O O O O O O O O O O O O O ";
        generation = new Generation(states);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNumSubrules() {
     int numberSubRules = 8;
     assertEquals(numberSubRules,rule.getNumSubrules());
    }

    @Test
    void getNeighborhood() {
        int index = 3;
        // For circular boundary conditions
        Cell[] neighborhoodForCellAt0 =
                {generation.getCell(generation.size() - 1),generation.getCell(0),generation.getCell(1)};
        Cell[] neighborhoodForCellAtEnd = {generation.getCell(generation.size() - 2), generation.getCell(generation.size() - 1),generation.getCell(0)};
        Cell[] neighborhoodForCellAtIndex = {generation.getCell(index - 1), generation.getCell(index),generation.getCell(index + 1)};

        assertArrayEquals(neighborhoodForCellAt0,rule.getNeighborhood(0,generation,circular));
        assertArrayEquals(neighborhoodForCellAtEnd,rule.getNeighborhood(generation.size() - 1,generation,circular));
        assertArrayEquals(neighborhoodForCellAtIndex,rule.getNeighborhood(index,generation, circular));

        // For fixed boundary conditions
        neighborhoodForCellAt0 = new Cell[]{fixed.getNeighbor(0, -1, generation), generation.getCell(0), generation.getCell(1)};
        neighborhoodForCellAtEnd = new Cell[]{generation.getCell(generation.size() - 2), generation.getCell(generation.size() - 1),fixed.getNeighbor(generation.size() - 1,1,generation)};
        neighborhoodForCellAtIndex = new Cell[]{fixed.getNeighbor(index,-1,generation),fixed.getNeighbor(index,0,generation),fixed.getNeighbor(index, 1, generation)};

        assertArrayEquals(neighborhoodForCellAt0,rule.getNeighborhood(0,generation,fixed));
        assertArrayEquals(neighborhoodForCellAtEnd,rule.getNeighborhood(generation.size() - 1,generation,fixed));
        assertArrayEquals(neighborhoodForCellAtIndex,rule.getNeighborhood(index,generation, fixed));
    }

    @Test
    void testToString() {
    }

    @Test
    void evolve() {
    }
}