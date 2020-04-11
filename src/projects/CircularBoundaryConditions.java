package projects;

/** This class represents the circular boundary conditions */
public class CircularBoundaryConditions implements BoundaryConditions {

    /** Create a circular boundary conditions*/
    public CircularBoundaryConditions(){

    }

    /** Implement the abstract method from the interface
     * */
    // TODO implement the method
    @Override
    public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
        return null; // Return any value;
    }
}
