package projects;

public class InvalidRuleNumException extends Exception {
    private static final long serialVersionUID = 1L;

    /** Create an exception
     * @param ruleNum The rule number
     * */
    public InvalidRuleNumException(int ruleNum){
        super("Invalid rule: " + ruleNum);
    }

}
