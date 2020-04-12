package projects;

public class TotalisticRule extends Rule{
     /** Data field: cell state for the rule*/
    CellState[] states;

    /**
     * Data field: maximum number of rules for an automaton
     */
    private final static int MAXIMUM_NUMBER_OF_RULES = 64;

    /** Create a totalistic rule
     * @param ruleNum The rule number of the totalistic rule
     * @throws InvalidRuleNumException Invalid rule number passed.
     */
    public TotalisticRule(int ruleNum) throws InvalidRuleNumException {
        super((ruleNum < 0 || ruleNum > MAXIMUM_NUMBER_OF_RULES)? -1 : ruleNum);

        String binaryRuleNum = Integer.toBinaryString(ruleNum);
        states = new CellState[binaryRuleNum.length()];

        for (int i = 0; i < binaryRuleNum.length(); i++)
            states[i] = (binaryRuleNum.charAt(i) == '1')? CellState.ON : CellState.OFF;
    }

    /** Get the number of sub rules
     * @return the total number of subrules*/
    @Override
    public int getNumSubrules() {
        return states.length;
    }

     /** Get the neighborhood of the cell at index cellIdx within a radius of 2.
     * @param cellIdx The index of the cell
     * @param gen Generation to be evolved
     * @param bc Boundary conditions that governs the evolution of the generation
     * @return the neighborhood of the cell at cellIdx
     * */
    @Override
    public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
        Cell[] neighborhood = new Cell[5];
        
        neighborhood[2] = bc.getNeighbor(cellIdx,0,gen);
        neighborhood[1] = bc.getNeighbor(cellIdx,-1,gen);
        neighborhood[0] = bc.getNeighbor(cellIdx,-2,gen);
        neighborhood[3] = bc.getNeighbor(cellIdx,1,gen);
        neighborhood[4] = bc.getNeighbor(cellIdx,2,gen);
        
        return neighborhood;
    }

    /** Evolve cell with the following neighborhood
     * @param neighborhood neighborhood of the cell at index 2 in the array.
     * @return evolved cell
     * */
    @Override
    public EvolvedCell evolve(Cell[] neighborhood) {
        int numberOfOn = 0;
        
        for (int i = 0; i < neighborhood.length; i++)
            if (neighborhood[i].getState() == CellState.ON)
                numberOfOn++;
            
        return new EvolvedCell(states[(getNumSubrules() - 1 - numberOfOn)],numberOfOn);
    }

    /** Get the string representation*/
    @Override
    //TODO implement
    public String toString() {
        return null; // return any value
    }
}
