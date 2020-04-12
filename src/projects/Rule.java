package projects;

/** This class represents the rule that governs the evolution of the automaton*/
public abstract class Rule {
    /** Data field: rule number*/
     private int ruleNum;

    /**Implement the constructor that will be used by subclasses
     * @param ruleNum  The rule number.*/
    protected Rule(int ruleNum){
   if (ruleNum < 0)
            throw new InvalidRuleNumException(ruleNum);
       this.ruleNum = ruleNum;
    }

    /** Get the rule number
     * @retunr rule number
     * */
    public int getRuleNum() {
        return ruleNum;
    }

     /** evolve the generation
     * @param gen  The generation to be evolved
     * @param bc The boundary conditions that is used for the evolution
     * @return evolved generation          
     * */
    public Generation evolve(Generation gen, BoundaryConditions bc){
         // Create an array of cell states
        EvolvedCell[] cells = new EvolvedCell[gen.size()];
        
        // Evolved cells
        for (int i = 0; i < gen.size(); i ++)
            cells[i] = evolve(getNeighborhood(i,gen,bc)); // evolve the cell at i;
        
        return new Generation(cells);
    }

    /** Get the number of sub rule
    * @return  the size of the rule table
    */
    public abstract int getNumSubrules();

    /** Get the neighborhood of the cell at index cellIdx
     * @param cellIdx The index of the cell
     * @param gen Generation to be evolved
     * @param bc Boundary conditions that governs the evolution of the generation
     * @return the neighborhood of the cell at cellIdx           
     * */
    public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);

    /**evolve cells
     * @param neighborhood  The neighborhood cells
     * @return evolved cell with the following neighborhood
     * */
    public abstract EvolvedCell evolve(Cell[] neighborhood);

   /** Get the string representation of the rule
     * @return String representation of the rule
     * */
    @Override
    public abstract String toString();
}
