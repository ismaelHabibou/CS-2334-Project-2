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

    /** evolve the generation*/
    //TODO implement the method
    public Generation evolve(Generation gen, BoundaryConditions bc){
        return null; // any value
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
