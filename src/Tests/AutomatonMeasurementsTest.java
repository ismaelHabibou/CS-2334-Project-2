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
    void testHammingDistance()throws InvalidStepNumException  {
       int stepNum = 7;
        assertEquals(computeHammingDistance(stepNum,automaton),
                AutomatonMeasurements.hammingDistance(stepNum,automaton));

    }

    @Test
    void testHammingDistance1() throws InvalidStepNumException{
        // Evolve automaton 10 steps
        automaton.evolve(10);

        assertEquals(computeHammingDistance(automaton),AutomatonMeasurements.hammingDistance(automaton));
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

   private static int computeHammingDistance(int stepNum,Automaton a) throws InvalidStepNumException {
        int distance = 0;
        if (stepNum > 0)
            distance = computeHammingDistance(a.geGeneration(stepNum),a.geGeneration(stepNum - 1));

        return distance;
    }

   private static int[] computeHammingDistance(Automaton automaton) throws InvalidStepNumException {
        int[] distances = new int[automaton.getTotalSteps()];

        for (int i = 1; i <= distances.length; i++)
            distances[i] = computeHammingDistance(i,automaton);

        return distances;
    }
}