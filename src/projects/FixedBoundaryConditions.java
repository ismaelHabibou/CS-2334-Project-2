package projects;

public class FixedBoundaryConditions implements BoundaryConditions {

    /** Data field: CellState left*/
    private CellState left;

    /**Data field: CellState right*/
    private CellState right;

    /** Create an instance of fixedBoundary conditions
     * @param left left cellState
     * @param right right cellState
     * */
    public FixedBoundaryConditions(CellState left, CellState right){
        this.left = left;
        this.right = right;
    }

    /** Get the left state
     * @return left
     * */
    public CellState getLeftState(){
        return left;
    }

    /** Get the right state
     * @return right
     * */
    public CellState getRightState(){
        return right;
    }

     /** Get the neighbor
     * @param cellIdx index of the cell
     * @param offset distance from cell at index CellIdx to the neighbor
     * @param gen the generation
     * @return cell
     * */
    @Override
    public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
        int indexOfNeighborCell = cellIdx + offset;
        Cell neighborCell; // reference of the neighbor cell

        if (indexOfNeighborCell < 0)
            neighborCell = new Cell(left);
        else if (indexOfNeighborCell >= gen.size())
            neighborCell = new Cell(right);
        else
            neighborCell = gen.getCell(indexOfNeighborCell);

        return neighborCell; // return the reference of neighbor cell
    }
}
