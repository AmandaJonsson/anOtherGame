/**
 * @author Miranda.
 * Revised by: Everybody.
 * Responsibility: A test that test methods in the Spave-class
 * Used by: -
 * Uses: ISPace
 */

package Model;

import Model.Interfaces.ISpace;
import org.junit.Test;

import static org.junit.Assert.*;


public class SpaceTest {
    @Test
    public void addAdjacentSpace() throws Exception {
        ISpace space1 = new Space(1, 1);
        ISpace space2 = new Space(2, 2);
        space1.addAdjacentSpace(space2);
        assertTrue(space1.getAdjacentSpaces().get(0).compareSpaces(space2));
    }

    @Test
    public void getAdjacentSpaces() throws Exception {
        ISpace space5 = new Space(1,1);
        ISpace space6 = new Space(2,2);
        space5.addAdjacentSpace(space6);
        assertTrue(space5.getAdjacentSpaces().get(0).compareSpaces(space6));
    }

    @Test
    public void getX() throws Exception {
        ISpace space3 = new Space(3,1);
        assertFalse(space3.getX() == 1);
        assertTrue(space3.getX() == 3);
    }

    @Test
    public void getY() throws Exception {
        ISpace space4 = new Space(2,4);
        assertFalse(space4.getY() == 1);
        assertTrue(space4.getY() == 4);
    }

    @Test
    public void compareSpaces() throws Exception {
        ISpace space1 = new Space(1,1);
        ISpace space2 = new Space(1,1);
        assertTrue(space1.compareSpaces(space2));

        ISpace space3 = new Space(2,5);
        ISpace space4 = new Space(1,1);
        assertFalse(space3.compareSpaces(space4));
    }
}