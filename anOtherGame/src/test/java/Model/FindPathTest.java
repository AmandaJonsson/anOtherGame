/**
 * @author
 * Revised by:
 * Responsibility: A test that test methods in the FindPath-class
 * Used by: -
 * Uses: IMap, MockMap
 */

package Model;

import Mocks.MockMap;
import Model.Intefaces.IMap;
import Model.Intefaces.IStation;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class FindPathTest {
    
    @Test
    public void findPotentialStations() throws Exception {
        IMap map1 = new MockMap();

        FindPath findPath1 = new FindPath();
        List<IStation> listOfStations1 = findPath1.findPotentialStations((Station) map1.getSpaces().get(3));
        assertTrue(listOfStations1.get(0).compareSpaces(map1.getSpaces().get(9)));
        assertTrue(listOfStations1.get(1).compareSpaces(map1.getSpaces().get(10)));

        FindPath findPath2 = new FindPath();
        List<IStation> listOfStations2 = findPath2.findPotentialStations((Station) map1.getSpaces().get(9));
        assertTrue(listOfStations2.get(0).compareSpaces(map1.getSpaces().get(3)));

        FindPath findPath3 = new FindPath();
        List<IStation> listOfStations3 = findPath3.findPotentialStations((Station) map1.getSpaces().get(10));
        assertTrue(listOfStations3.get(0).compareSpaces(map1.getSpaces().get(3)));
    }

    @Test
    public void findPotentialSpaces() throws Exception {


    }

    @Test
    public void getPotentialSpaces() throws Exception {


    }

    @Test
    public void getPotentialStations() throws Exception {


    }

    @Test
    public void testFindPotentialSpaces() throws Exception {
        //IMap map = new MockMap();


    }
}

