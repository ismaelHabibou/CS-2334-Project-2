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

    AutomatonTest() throws InvalidRuleNumException {
    }

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
    void geGeneration() throws InvalidStepNumExceptio {
        Generation evolvedGeneration = new Generation(" OO O O OO ");

        assertEquals(evolvedGeneration.toString(),automaton.geGeneration(1).toString());
    }

    @Test
    void getBc() {
      assertEquals(conditions,automaton.getBc());
    }

    @Test
    void evolve()throws InvalidStepNumException {
        Generation evolvedGeneration = new Generation(" OO O O OO ");
        automaton.evolve(1);

        boolean correct = true;
        if (!evolvedGeneration.toString().equals(automaton.geGeneration(1).toString()))
            correct = false;
        if (!gen2.toString().equals(automaton.geGeneration(0).toString()))
            correct = false;

        assertTrue(correct);
    }

    @Test
    void getTotalSteps()throws InvalidStepNumException{
        int totalSteps = 10;
        automaton.evolve(totalSteps);

        assertEquals(totalSteps -1,automaton.getTotalSteps());
    }

    @Test
    void testToString() {
        Generation evolvedGeneration = new Generation(" OO O O OO ");
        
        assertEquals(evolvedGeneration.toString(),automaton.toString());
    }

    @Test
    void getHistory() throws InvalidStepNumException{
        Generation evolvedGeneration = new Generation(" OO O O OO ");
        String history = evolvedGeneration.toString() + "\n" + gen2.toString();
        
        automaton.evolve(1);
        
        assertEquals(history,automaton.getHistory());   
    }
}