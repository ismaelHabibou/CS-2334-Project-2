package projects;

public class TotalisticRule extends Rule{
    // TODO declare data fields

    /** Create a totalistic rule*
     */
    //TODO Implement
    public TotalisticRule(int ruleNum){
        super(ruleNum);
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
