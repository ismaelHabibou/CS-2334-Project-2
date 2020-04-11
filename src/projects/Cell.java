package projects;

/**
 * This class models the cell in the automaton
 */
public class Cell {
    /** Data field: Cell state*/
    private CellState state;

    /** Create a default cell object*/
    public Cell(){
        this(CellState.OFF);
    }

    /**
     * Create a cell with specific state
     *
     * @param state state of the cell
     */
    public Cell(CellState state) {
        this.state = state;
    }

    /** Get the state of the cell
     * @return state of the cell
     * */
    public CellState getState(){
        return state;
    }

    /** Get the symbol of the cell
     * @return symbol of the cell
     * */
    @Override
    public String toString(){
        return state.toString();
    }

}
