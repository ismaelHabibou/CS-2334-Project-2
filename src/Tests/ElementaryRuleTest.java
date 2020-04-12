package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import projects.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ElementaryRuleTest {
    private int ruleNumber = 22;
    /** Create an elementary rule object*/
    Rule rule = new ElementaryRule(ruleNumber);

    /** Create a generation for the rule*/
    static Generation generation ;

    /** Create boundary conditions*/
    static BoundaryConditions circular = new CircularBoundaryConditions();

    /** Create a fixed boundary conditions*/
    static BoundaryConditions fixed = new FixedBoundaryConditions(CellState.OFF,CellState.ON);

    ElementaryRuleTest() throws InvalidRuleNumException {
    }

    @BeforeEach
    void setUp() {
         String states = "       O       ";
        generation = new Generation(states);
    }

    @AfterEach
    void tearDown() {
     generation = null;
    }

    @Test
    void getNumSubrules() {
     int numberSubRules = 8;
     assertEquals(numberSubRules,rule.getNumSubrules());
    }
   
   @Test
    void getRuleNumber(){
        assertEquals(ruleNumber,rule.getRuleNum());
    }

   @Test
    void evolve(){
        Cell[] cells = new Cell[generation.size()];
        for (int i = 0; i < cells.length; i++)
            cells[i] = new Cell(CellState.OFF);

        cells[6] = new Cell(CellState.ON);
        cells[7] = new Cell(CellState.ON);
        cells[8] = new Cell(CellState.ON);
        System.out.println(new Generation(cells).toString());

        assertEquals(new Generation(cells).toString(),rule.evolve(generation,circular).toString());
    }

    @Test
    void testToString() {
      String on = CellState.ON.toString();
      String off = CellState.OFF.toString();

        String ruleString = on + on + on + " " + on + on + off + " " + on + off + on + " " + on + off + off + " " +
                off + on + on + " " + off + on + off + " " + off + off + on + " " + off + off + off + "\n" + ruleToString(ruleNumber);

        assertEquals(ruleString,rule.toString());

    }


 /** Convert rule to String*/
    private static String ruleToString(int ruleNumber){
        StringBuilder buffer = new StringBuilder();
        String ruleNumString = addLeadingZero(Integer.toBinaryString(ruleNumber));

        for (int i = 0; i < ruleNumString.length(); i++)
            buffer.append(" ").append(ruleNumString.charAt(i) == '1'? CellState.ON.toString() : CellState.OFF.toString()).append("  ");

        buffer.deleteCharAt(buffer.length() - 1);

        return buffer.toString();
    }

    private static String addLeadingZero(String binaryString) {
        final int NUMBER_OF_BINARY_DIGIT = 8;
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < NUMBER_OF_BINARY_DIGIT - binaryString.length(); i++)
            buffer.append("0");
        buffer.append(binaryString);

        return buffer.toString();
    }
}