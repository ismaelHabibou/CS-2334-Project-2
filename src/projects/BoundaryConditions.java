package projects;

/** This interface represents the boundary conditions*/
public interface BoundaryConditions {

    /** Get the neighbor
     * @param cellIdx
     * @param offset
     * @param gen*/
    // TODO implement in classes that have implemented the interface
    Cell getNeighbor(int cellIdx, int offset, Generation gen);
}
