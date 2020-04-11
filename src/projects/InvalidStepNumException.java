package projects;

public class InvalidStepNumException extends Exception {
    private static final long serialVersionUID = 1L;

    /** Construct the exception*/
    public InvalidStepNumException(int stepNum){
        super("Invalid step number: " + stepNum);
    }
}
