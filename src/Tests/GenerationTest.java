package Tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import projects.Generation;

import static org.junit.jupiter.api.Assertions.*;

public class GenerationTest {
    private String states = " O O O O O O O O O O O O O O O O O ";
    /** Create a generation*/
    private Generation generation ;

    @BeforeEach
    public void setUp() {
        generation = new Generation(states);
    }

    @AfterEach
    public void tearDown() {
    }

    @Test
    public void size() {
        assertEquals(states.length(),generation.size());
    }

    @Test
    public void getCell() {
        boolean fine = true;
        for (int i = 0; i < states.length(); i++)
            if (generation.getCell(i) == null)
                fine = false;
        assertTrue(fine);
    }

    @Test
    public void testToString() {
        assertEquals(states,generation.toString());
    }
}