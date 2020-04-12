package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.*;

import static org.junit.jupiter.api.Assertions.*;

class TotalisticRuleTest {
    /** Rule number*/
    private int ruleNum = 22;

    /**Totalistic rule*/
    Rule rule = new TotalisticRule(ruleNum);

    /** Generation*/
    Generation generation = new Generation("   OOOOO   ");

    /**BoundaryConditions*/
    BoundaryConditions circular = new CircularBoundaryConditions();

    TotalisticRuleTest() throws InvalidRuleNumException {
    }


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNumSubrules() {
    }

    @Test
    void getNeighborhood() {
    }

    @Test
    void evolve() {
    }

    @Test
    void testToString() {
    }
}