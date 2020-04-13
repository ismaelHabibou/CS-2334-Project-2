package projects;

public class InvalidStepNumException extends Exception {
    private static final long serialVersionUID = 1L;

 /** Construct the exception
     * @param stepNum The step number
     * */
    public InvalidStepNumException(int stepNum){
        super("Invalid step number: " + stepNum);
    }
}
