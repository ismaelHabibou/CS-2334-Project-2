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

     @ParameterizedTest
    @MethodSource("arrayStream1")
    void getNeighborhoodWithCircularBoundary(Object[][] myObject) {
        int index = (Integer) myObject[0][0];
        Cell[] cells = (Cell[]) myObject[1];

        assertArrayEquals(cells, rule.getNeighborhood(index,generation,circular));

    }

    @ParameterizedTest
    @MethodSource("arrayStream2")
    void getNeighborhoodWithFixedBoundary(Object[][] myObject) {
        int index = (Integer) myObject[0][0];
        Cell[] cells = (Cell[]) myObject[1];

        assertArrayEquals(cells, rule.getNeighborhood(index,generation,fixed));

    }

    @Test
    void testToString() {
      String on = CellState.ON.toString();
      String off = CellState.OFF.toString();

        String ruleString = on + on + on + " " + on + on + off + " " + on + off + on + " " + on + off + off + " " +
                off + on + on + " " + off + on + off + " " + off + off + on + " " + off + off + off + "\n" + ruleToString(ruleNumber);

        assertEquals(ruleString,rule.toString());

    }


    @ParameterizedTest
    @MethodSource("arrayStream")
    void testEvolve(Object myStates) {
        Cell[][] states = (Cell[][]) myStates;

        assertSame(states[0][0], rule.evolve(states[1]));

    }


    static Stream<Arguments> arrayStream(){
        return Stream.of(Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.OFF, 7)}, {new Cell(CellState.ON), new Cell(CellState.ON), new Cell(CellState.ON)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.OFF, 6)}, {new Cell(CellState.ON), new Cell(CellState.ON), new Cell(CellState.OFF)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.OFF, 5)}, {new Cell(CellState.ON), new Cell(CellState.OFF), new Cell(CellState.ON)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.ON, 4)}, {new Cell(CellState.ON), new Cell(CellState.OFF), new Cell(CellState.OFF)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.OFF, 3)}, {new Cell(CellState.OFF), new Cell(CellState.ON), new Cell(CellState.ON)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.ON, 2)}, {new Cell(CellState.OFF), new Cell(CellState.ON), new Cell(CellState.OFF)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.ON, 1)}, {new Cell(CellState.OFF), new Cell(CellState.OFF), new Cell(CellState.ON)}}),
                Arguments.arguments((Object) new Object[][]{{new EvolvedCell(CellState.OFF, 0)}, {new Cell(CellState.OFF), new Cell(CellState.OFF), new Cell(CellState.OFF)}})
        );
    }

 /** Parametrize test for circular boundary condition*/
     static Stream<Arguments> arrayStream1(){

        return Stream.of(Arguments.arguments( new Object[][]{{0}, {circular.getNeighbor(0,-1 , generation),
                        circular.getNeighbor(0,0,generation),circular.getNeighbor(0,1,generation)}}),
                Arguments.arguments( new Object[][]{ {generation.size() - 1}, {circular.getNeighbor(generation.size() - 1,-1 , generation),
                        circular.getNeighbor(generation.size() - 1,0,generation),circular.getNeighbor(generation.size() - 1,1,generation)}}),
                Arguments.arguments( new Object[][]{{3}, {circular.getNeighbor(3,-1 , generation),circular.getNeighbor(3,0,generation),
                        circular.getNeighbor(3,1,generation)}})
        );

    }

    /** Parametrize test for fixed boundary conditions*/
    static Stream<Arguments> arrayStream2(){
        return Stream.of(Arguments.arguments(new Object[][]{{0}, {fixed.getNeighbor(0, -1, generation),
                        fixed.getNeighbor(0, 0, generation),fixed.getNeighbor(0, 1, generation)}}),
                Arguments.arguments(new Object[][]{{generation.size() -1}, {fixed.getNeighbor(generation.size() - 1,-1,generation),
                        fixed.getNeighbor(generation.size() - 1,0,generation),fixed.getNeighbor(generation.size() - 1,1,generation)}}),
                Arguments.arguments(new Object[][]{{3}, {fixed.getNeighbor(3,-1,generation),fixed.getNeighbor(3,0,generation),
                        fixed.getNeighbor(3, 1, generation)}}));
    }

 /** Convert rule to String*/
    private static String ruleToString(int ruleNumber){
        StringBuilder buffer = new StringBuilder();
        String ruleNumString = addLeadingZero(Integer.toBinaryString(ruleNumber));

        for (int i = 0; i < ruleNumString.length(); i++)
            buffer.append(" ").append(ruleNumString.charAt(i) == '1'? CellState.ON.toString() : CellState.OFF.toString()).append(" ");

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