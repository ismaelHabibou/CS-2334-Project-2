package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.*;

import static org.junit.jupiter.api.Assertions.*;

class AutomatonTest {
    private int ruleNum = 22;
    /** Generations*/
    Generation gen2 = new Generation("   OOOOO   ");

    /** Rules*/
    Rule rule1 = new ElementaryRule(ruleNum);

    /** Boundary conditons*/
    BoundaryConditions conditions = new CircularBoundaryConditions();

    /** Automatons*/
    Automaton automaton = new Automaton(rule1,gen2,conditions);

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getRule() {
       assertEquals(rule1,automaton.getRule());
    }

    @Test
    void geGeneration() {
    }

    @Test
    void getBc() {
    }

    @Test
    void evolve() {
    }

    @Test
    void getTotalSteps() {
    }

    @Test
    void testToString() {
    }

    @Test
    void getHistory() {
    }
}