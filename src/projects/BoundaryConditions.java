package projects;

/** This interface represents the boundary conditions*/
public interface BoundaryConditions {

       /** Get the neighbor
     * @param cellIdx index of the cell
     * @param offset distance from cell at index CellIdx to the neighbor
     * @param gen the generation
     * @return cell
     * */
    Cell getNeighbor(int cellIdx, int offset, Generation gen);
}
