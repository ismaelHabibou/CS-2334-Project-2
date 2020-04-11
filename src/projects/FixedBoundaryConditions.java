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

    /** Get neighbor
     * @param cellIdx
     * @param offset
     * @param gen
     * */

    @Override
    public Cell getNeighbor(int cellIdx, int offset, Generation gen) {
        return null; // return any value
    }
}
