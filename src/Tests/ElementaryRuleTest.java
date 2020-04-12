package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.ElementaryRule;
import projects.Rule;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryRuleTest {
    private int ruleNumber = 22;
    /** Create an elementary rule object*/
    Rule rule = new ElementaryRule(ruleNumber);

    @BeforeEach
    void setUp() {
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