package projects;

/** This class represents the circular boundary conditions */
public class CircularBoundaryConditions implements BoundaryConditions {

    /** Create a circular boundary conditions*/
    public CircularBoundaryConditions(){

    }

  /** Get the neighbor
     * @param cellIdx index of the cell
     * @param offset distance from cell at index CellIdx to the neighbor
     * @param gen the generation
     * @return cell
     * */
    @Override
    public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
           int indexOfNeighbor = (cellIdx + offset);
         indexOfNeighbor = (indexOfNeighbor) >= 0? indexOfNeighbor % gen.size() : indexOfNeighbor % gen.size();

         if (indexOfNeighbor < 0)
             indexOfNeighbor += gen.size();

        return gen.getCell(indexOfNeighbor);
    }
}
