package projects;

public class AutomatonMeasurements {

/** Compute the hamming distance between two generations
     * @param g1 First generation
     * @param g2 Second generation
     * @return the hamming distance between two generations.
     * */
    public static int hammingDistance(Generation g1, Generation g2){
        if (g1 == null || g2 == null)
            throw new NullPointerException();

        if (g1.size() != g2.size())
            throw new IllegalArgumentException("The two generations have different sizes");
        
        int distance = 0;
        for (int i = 0; i < g1.size(); i++)
            if (g1.getCell(i).getState() != g2.getCell(i).getState())
                distance++;
            
        return distance; //return the distance
    }

    /** Get the hamming distance between two successive generations
     * @param stepNum The step number
     * @param a The automaton
     * @return the hamming distance between the generations at stepNum and stepNum-1
     * @throws InvalidStepNumException The step number is invalid.
     * */
    public static int hammingDistance(int stepNum, Automaton a) throws InvalidStepNumException {
        if (a == null)
            throw new NullPointerException();
        
        return hammingDistance(a.geGeneration(stepNum),a.geGeneration(stepNum - 1));
    }

    /** Get the hamming distance between two successive steps of the automaton
     * @param a The automaton
     * @throws InvalidStepNumException The step number is invalid.         
     * @return an array of integers that contains the hamming distance between successive steps
     * */
    public static int[] hammingDistance(Automaton a) throws InvalidStepNumException {
        int[] distances = new int[a.getTotalSteps()];
        
        for (int i = 1; i <= a.getTotalSteps(); i++)
            distances[i - 1] = hammingDistance(i,a);
        return new int[0]; // return any value
    }

    /** Get the total count of subrule for the evolution of the generation with step number stepNum
     * @param stepNum The step number of the generation
     * @return count of the occurrences of individual subrules
     * */
    public static int[] subruleCount(int stepNum, Automaton a) throws InvalidStepNumException {
        Generation generation = a.geGeneration(stepNum); // generation at stepNum
        int[] count = new int[a.getRule().getNumSubrules()];
        EvolvedCell temp; // temporary cell
        
        for (int i = 0; i < generation.size(); i++){
            temp = (EvolvedCell) generation.getCell(i);
            count[temp.getSubruleNum()]++; // increment the count of the subrule
        }
            
        return count; // return count
    }

    //TODO implement
    public static int[][] subruleCounts(Automaton a){
        return new int[0][0]; // return any value
    }
}
