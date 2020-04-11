package projects;

import java.util.HashMap;
import java.util.Map;

/** State of the cell*/
public enum CellState {
    OFF(' '), ON('O');

    /** Data field: symbol*/
    private char symbol;

    /** Data field: symbol to state*/
    static Map<Character, CellState> SYMBOL_TO_STATE;

    /* Create a static instance initializer to initialize the above static variable*/
    static {
        SYMBOL_TO_STATE = new HashMap<>();

        // Add the pairs to the map
        SYMBOL_TO_STATE.put(ON.symbol,ON);
        SYMBOL_TO_STATE.put(OFF.symbol,OFF);
    }

    /** Create an enum type*/
    CellState(char symbol){
        this.symbol = symbol;
    }

    /**Get the cellState.
     * @return cell state
     * @param symbol the symbol that represents the cell state.
     * */
    public static CellState getState(char symbol){
        return SYMBOL_TO_STATE.get(symbol);
    }

    /** Ge the string representation of the symbol that represents the Cell state
     * @return string representation of cell state.
     * */
    @Override
    public String toString(){
        return symbol + "";
    }
}
