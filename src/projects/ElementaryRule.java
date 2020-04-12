package projects;

public class ElementaryRule extends Rule{
    /** Data field: different states of cells*/
    private CellState[] states;
 
    /** Create an elementary rule
     * @param ruleNum This is the rule number use to construct an elementary rule object.
     * */
    public ElementaryRule(int ruleNum){
        super(ruleNum);

        // Binary representation of the rule number
        String binaryRuleNum = addLeadingZero(Integer.toBinaryString(ruleNum));
        states = new CellState[binaryRuleNum.length()];
        
        // Fill array with cell state
        fillArray(binaryRuleNum, states);
    }

 /** fill the array with cell states
     * @param binaryRuleNum The binary representation of the rule.
     * @param states An array representation of the rule.
     * */
    private static void fillArray(String binaryRuleNum, CellState[] states){
        for (int i = 0; i < binaryRuleNum.length(); i++)
            states[i] = binaryRuleNum.charAt(i) == '1'? CellState.ON : CellState.OFF;
    }

    /** Add leading zero to the binary representation of the rule number
     * @return a rule with 8 bits.
     * */
    public static String addLeadingZero(String binaryRule){
        final int MAX_LENGTH = 8;
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < MAX_LENGTH - binaryRule.length(); i++)
            buffer.append('0');

        buffer.append(binaryRule);
        buffer.trimToSize();
        return buffer.toString();
    }

    /** Get the number of sub rules*/
    //TODO implement
    @Override
    public int getNumSubrules() {
        return 0;// return value
    }

    /** Get neighborhood */
    //TODO implement
    @Override
    public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
        return new Cell[0]; // return value
    }

    /** Get the string representation of the rule*/
    //TODO implement
    @Override
    public String toString() {
        return null;// return value
    }

    /** Evolve*/
    //TODO implement

    @Override
    public EvolvedCell evolve(Cell[] neighborhood) {
        return null; // return value
    }
}
