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
@Test
    void hammingDistance() {
        Generation generation = new Generation("      OOO      ");

        assertEquals(computeHammingDistance(generation,firstGenerations),
                AutomatonMeasurements.hammingDistance(generation,firstGenerations));
    }
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

    private static int computeHammingDistance(Generation generation1, Generation generation2){
        if (generation1.size() != generation2.size())
            throw new IllegalArgumentException("Generations have different sizes.");

        int difference = 0;

        for (int i = 0; i < generation1.size(); i++)
            if (generation1.getCell(i) == generation2.getCell(i))
                difference++;

    return difference;
    }
}