package projects;

/** This class represents a cell class with sub-rule number*/
public class EvolvedCell extends Cell{

    /**Data field: sub-rule number*/
    private int subruleNum;

    /** Create an instance of evolved cell
     * @param state The state of the cell
     * @param subruleNum The sub rule of the cell
     */
    public EvolvedCell(CellState state,int subruleNum){
        super(state);
        this.subruleNum = subruleNum;

    }

    /** Get the sub rule of the cell
     * @return sub rule of the cell
     * */
    public int getSubruleNum() {
        return subruleNum;
    }
}
