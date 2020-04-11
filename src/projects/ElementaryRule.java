package projects;

public class ElementaryRule extends Rule{
    //TODO declare data fields

    /** Create an elementary rule*/
    public ElementaryRule(int ruleNum){
        super(ruleNum);
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
