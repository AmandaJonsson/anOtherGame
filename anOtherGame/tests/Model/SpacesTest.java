package Model;

import org.junit.Test;

import static org.junit.Assert.*;


public class SpacesTest {

    @Test
    public void testEquals() throws Exception {
        ISpace space1 = new Spaces(1,1);
        ISpace space2 = new Spaces(1,1);
        assertTrue(space1.compareSpaces(space2));

        ISpace space3 = new Spaces(2,5);
        ISpace space4 = new Spaces(1,1);
        assertFalse(space3.compareSpaces(space4));
    }
}