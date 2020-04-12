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

    /** Get the number of sub rules
     * @return Number of the sub rules
     * */
    @Override
    public int getNumSubrules() {
        return states.length;
    }

    /** Get the neighborhood of the cell at index cellIdx
     * @param cellIdx The index of the cell
     * @param gen Generation to be evolved
     * @param bc Boundary conditions that governs the evolution of the generation
     * @return the neighborhood of the cell at cellIdx
     * */
    @Override
    public Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc) {
        Cell[] neighbors = new Cell[3];
        neighbors[1] = bc.getNeighbor(cellIdx,0,gen);
        neighbors[0] = bc.getNeighbor(cellIdx, -1,gen);
        neighbors[2] = bc.getNeighbor(cellIdx, 1,gen);
        
        return neighbors; // return the reference of neighbors.
    }

    /** Get the string representation of the rule*/
    //TODO implement
    @Override
    public String toString() {
        return null;// return value
    }

   /** Evolve
     * @param neighborhood Evolve the cell with following neighbors
     * @return evolved cell
     * */
    @Override
    public EvolvedCell evolve(Cell[] neighborhood) {
        int subruleNumber = neighborhood[0].getState() == CellState.ON? 1 : 0;

        for (int i = 0; i < neighborhood.length - 1; i++)
            subruleNumber = subruleNumber * 2 + (neighborhood[i + 1].getState() == CellState.ON? 1 : 0);

        return new EvolvedCell(states[subruleNumber],subruleNumber);
    }
}
