package projects;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: CS 2334-001 Programing Structures and Abstractions
 * Instructor: Rafal Jabrazemski
 * Description: This class models an automaton.
 * It has the number  of sections, number of students, the name of the course and maximum number of students per section.
 * Due: January t6th 2020
 * I pledge I have done this work independently.
 * I pledge I have not copied my code from someone's else.
 * I pledge I have not share my code with any of my classmates.
 *
 * Sign in: Ismael Habibou Issaka
 */
public class Automaton {

    /**Data field: rule*/
    private Rule rule;

    /** Data field: generations*/
    private List<Generation> generations;

    /** Data field: background conditions*/
    private BoundaryConditions bc;

   /** Create an automaton
     * @param rule The rule that governs the evolution of the automaton
     * @param intit The inititial generation
     * @param bc The boundary conditions
     * */
    public Automaton(Rule rule, Generation intit, BoundaryConditions bc) {
        this.rule = rule;
        this.bc = bc;
        this.generations = new ArrayList<>();
        generations.add(intit);
    }

    /** Get the rule
     * @return the rule used to construc the automaton
     * */
    public Rule getRule() {
        return rule;
    }

     /** Get the generation
     * @param stepNum The number times the automaton has evolved
     * @throws InvalidStepNumException This exception is thrown when the step number is invalid.  
     * @return the generation which has a step number stepNum             
     * */
    public Generation getGeneration(int stepNum) throws InvalidStepNumException {
        if (stepNum < 0)
            throw new InvalidStepNumException(stepNum);

        else if (stepNum > getTotalSteps())
            evolve(stepNum);

        return generations.get(stepNum);
    }

    /** Get the boundary conditions
     * @return the boundary condition
     * */
    public BoundaryConditions getBoundaryConditions() {
        return bc;
    }

     /** evolve the automaton
     * @throws InvalidStepNumException The step number is invalid.
     * @param stepNum The step Number
     * */
    public void evolve(int stepNum) throws InvalidStepNumException {
        if (stepNum < 0)
            throw new InvalidStepNumException(stepNum);
        
        // Remove everything from the list of generations except the initial generation
        for (int i = generations.size() - 1; i > 0; i--)
            generations.remove(i);
        
        // Evolve the automaton stepNum times
        for (int i = 0; i < stepNum; i++)
            generations.add(rule.evolve(generations.get(generations.size() - 1),bc));
    }
    /** Get the total steps
     * @return the total number of steps
     * */

    public int getTotalSteps(){
        return generations.size() - 1;
    }

    /** Get the string representation of the automaton
     * @return the string representation of the generation at the top
     * */
    @Override
    public String toString(){
        return generations.get(generations.size() - 1).toString();
    }

    /** Get the automaton history
    * @return string representation of all the different steps
     * */
    public String getHistory(){
        StringBuilder buffer = new StringBuilder(); // store the string state representation of all the generations

        for (int i = 0; i < generations.size(); i++) {
            buffer.append(generations.get(i).toString());
            if (i != generations.size() - 1)
                buffer.append("\n");
        }

        return buffer.toString(); // return the string representation of the automaton
    }

}
