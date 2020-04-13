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

        assertTrue(areArraysEqual(computeHammingDistance(automaton),AutomatonMeasurements.hammingDistance(automaton)));
    }

    @Test
    void subruleCount() throws InvalidStepNumException{
        int stepNum = 10;

        assertTrue(areArraysEqual(getSubruleCounts(stepNum,automaton),AutomatonMeasurements.subruleCount(stepNum,automaton)));
    }

    @Test
    void subruleCounts() throws InvalidStepNumException {
     boolean correct = true;
        int[][] expected = getSubruleCounts(automaton);
        int[][] actual = AutomatonMeasurements.subruleCounts(automaton);

        for (int i = 0; i < expected.length; i++)
            if (!areArraysEqual(expected[i],actual[i]))
                correct = false;

        assertTrue(correct);
    }
    
     private boolean areArraysEqual(int[] expected, int[] actual){
        boolean correct = true;

        for (int i = 0; i < actual.length; i++)
            if (actual[i] != expected[i])
                correct = false;

        return correct;
    }

    private static int computeHammingDistance(Generation generation1, Generation generation2){
        if (generation1.size() != generation2.size())
            throw new IllegalArgumentException("Generations have different sizes.");

        int difference = 0;

        for (int i = 0; i < generation1.size(); i++)
            if (generation1.getCell(i).getState() != generation2.getCell(i).getState())
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
            distances[i - 1] = computeHammingDistance(i,automaton);

        return distances;
    }

  private static int[] getSubruleCounts(int stepNum, Automaton a) throws InvalidStepNumException {
        int[] counts = new int[a.getRule().getNumSubrules()];

        Generation generation = a.geGeneration(stepNum);

        EvolvedCell cellAt;
        for (int i = 0; i < generation.size(); i++){
            cellAt = (EvolvedCell) generation.getCell(i);

            counts[cellAt.getSubruleNum()]++;
        }

        return counts;
    }

   private static int[][] getSubruleCounts(Automaton a) throws InvalidStepNumException {
        int[][] distances = new int[a.getTotalSteps()][a.getRule().getNumSubrules()];

        for (int i = 1; i <= a.getTotalSteps(); i++)
            distances[i - 1] = getSubruleCounts(i,a);

        return distances;
    }
}