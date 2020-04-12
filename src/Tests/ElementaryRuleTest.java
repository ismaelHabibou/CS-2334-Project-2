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
    }

    @Test
    void testToString() {
    }

    @Test
    void evolve() {
    }
}