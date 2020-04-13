package Tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutomatonMeasurementsTest {
 /** Create necessary resources */
    Rule rule = new ElementaryRule(22);
    BoundaryConditions circular = new CircularBoundaryConditions();
    Generation firstGenerations = new Generation("       O       ");

    Automaton automaton = new Automaton(rule,firstGenerations,circular);

    AutomatonMeasurementsTest() throws InvalidRuleNumException {
    }

    @Test
    void hammingDistance() {
    }

    @Test
    void testHammingDistance() {
    }

    @Test
    void testHammingDistance1() {
    }

    @Test
    void subruleCount() {
    }

    @Test
    void subruleCounts() {
    }
}