package Model;

import Model.Intefaces.ISpace;
import org.junit.Test;

import static org.junit.Assert.*;


public class SpaceTest {
    @Test
    public void addAdjacentSpace() throws Exception {
    }

    @Test
    public void getAdjacentSpaces() throws Exception {
    }

    @Test
    public void getX() throws Exception {
    }

    @Test
    public void getY() throws Exception {
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

    @Test
    public String toString() {
        return null;
    }

}