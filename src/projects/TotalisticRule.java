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

    /** Get the number of sub rules*/
    //TODO implement
    @Override
    public int getNumSubrules() {
        return 0;
    }

     /** Get neighborhood*/
     //TODO implement
    @Override
    public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
        return new Cell[0]; // return value
    }

    /** Evolve cell*/
    //TODO implement
    @Override
    public EvolvedCell evolve(Cell[] neighborhood) {
        return null; // value
    }

    /** Get the string representation*/
    @Override
    //TODO implement
    public String toString() {
        return null; // return any value
    }
}
