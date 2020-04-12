package projects;

/** This class represents the rule that governs the evolution of the automaton*/
public abstract class Rule {
    /** Data field: rule number*/
     private int ruleNum;

    /**Implement the constructor that will be used by subclasses
     * @param ruleNum  The rule number.*/
    protected Rule(int ruleNum){
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

    /** Get the number of sub rule*/
    public abstract int getNumSubrules();

    /** Get the neighborhood*/
    public abstract Cell[] getNeighborhood(int cellIdx, Generation gen, BoundaryConditions bc);

    /**evolve cells*/
    public abstract EvolvedCell evolve(Cell[] neighborhood);

    /** Gte the string representation of the rule*/
    @Override
    public abstract String toString();
}
