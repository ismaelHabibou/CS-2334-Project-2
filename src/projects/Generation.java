package projects;

/**
 * This class models the individual rows of the automaton also known as generation
 */
public class Generation {
    /** Data field: cells*/
    private Cell[] cells;

    /** Create a generation from an array of CellStates
     * @param states an array of CellState*/
    public Generation(CellState[] states){
        cells = new Cell[states.length];

        for (int i = 0; i < states.length; i++)
            cells[i] = new Cell(states[i]);
    }

    /** Create a generation from an array of cells
     * @param cells an array of cells
     * */
    public Generation(Cell[] cells){
        this.cells = new Cell[cells.length];

        for (int i = 0; i < cells.length; i++)
            this.cells[i] = new Cell(cells[i].getState());
    }

    /** Create a generation using a string*/
    public Generation(String states){
        cells = new Cell[states.length()];

        // Fill the cells
        fillCells(cells,states);

    }

    /** fill the array of cells*/
    public static void fillCells(Cell[] cells, String states){
        CellState temp; // temporary variable;

        for (int i = 0; i < states.length(); i++) {
            temp = CellState.getState(states.charAt(i));
            if (temp == null)
                throw new IllegalArgumentException("Invalid symbol: " + states.charAt(i));
            cells[i] = new Cell(temp);
        }
    }

    /** Get the size of the generation
     * @return the size of the generation
     * */
    public int size(){
        return cells.length;
    }

    /** Get cell at a specific index
     * @return the cell at idx
     * */
    public Cell getCell(int idx){
        return cells[idx];
    }

    /** Return the string representation of the cell*/
    @Override
    public String toString(){
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < cells.length; i++)
            buffer.append(cells[i].toString());

        return buffer.toString(); // return the string representation of the generation.
    }
}
