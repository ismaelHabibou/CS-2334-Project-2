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

    //TODO implement
    public static int hammingDistance(int stepNum, Automaton a){
        return 0;// return a value
    }

    //TODO implement
    public static int[] hammingDistance(Automaton a){
        return new int[0]; // return any value
    }

    //TODO implement
    public static int[] subruleCount(int stepNum, Automaton a){
        return new int[0]; // return any value;
    }

    //TODO implement
    public static int[][] subruleCounts(Automaton a){
        return new int[0][0]; // return any value
    }
}
