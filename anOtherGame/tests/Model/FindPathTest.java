package Model;

import Mocks.MockMap;
import Model.Intefaces.IMap;
import org.junit.Test;

import static org.junit.Assert.*;


public class FindPathTest {

    @Test
    public void testFindPotentialSpaces() throws Exception {
        IMap map = new MockMap();

        System.out.println(map.getSpaces().get(2));
        System.out.println();
        FindPath.printListOfSpaces(FindPath.findPotentialSpaces(2,map.getSpaces().get(2)));
    }
}

