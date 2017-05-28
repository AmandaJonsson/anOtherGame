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
import Model.Intefaces.ISpace;
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
        IMap map2 = new MockMap();

        FindPath findPath4 = new FindPath();
        List<ISpace> listOfPotentialSpaces1 = findPath4.findPotentialSpaces(1, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces1.get(0).compareSpaces(map2.getSpaces().get(1)));

        FindPath findPath5 = new FindPath();
        List<ISpace> listOfPotentialSpaces2 = findPath5.findPotentialSpaces(2, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces2.get(0).compareSpaces(map2.getSpaces().get(2)));

        FindPath findPath6 = new FindPath();
        List<ISpace> listOfPotentialSpaces3 = findPath6.findPotentialSpaces(3, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces3.get(0).compareSpaces(map2.getSpaces().get(3)));

        FindPath findPath7 = new FindPath();
        List<ISpace> listOfPotentialSpaces4 = findPath7.findPotentialSpaces(4, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces4.get(0).compareSpaces(map2.getSpaces().get(4)));
        assertTrue(listOfPotentialSpaces4.get(1).compareSpaces(map2.getSpaces().get(6)));
        assertTrue(listOfPotentialSpaces4.get(2).compareSpaces(map2.getSpaces().get(3)));

        FindPath findPath8 = new FindPath();
        List<ISpace> listOfPotentialSpaces5 = findPath8.findPotentialSpaces(5, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces5.get(0).compareSpaces(map2.getSpaces().get(5)));
        assertTrue(listOfPotentialSpaces5.get(1).compareSpaces(map2.getSpaces().get(7)));
        assertTrue(listOfPotentialSpaces5.get(2).compareSpaces(map2.getSpaces().get(3)));

        FindPath findPath9 = new FindPath();
        List<ISpace> listOfPotentialSpaces6 = findPath9.findPotentialSpaces(6, map2.getSpaces().get(0));
        assertTrue(listOfPotentialSpaces6.get(0).compareSpaces(map2.getSpaces().get(9)));
        assertTrue(listOfPotentialSpaces6.get(1).compareSpaces(map2.getSpaces().get(8)));
        assertTrue(listOfPotentialSpaces6.get(2).compareSpaces(map2.getSpaces().get(3)));

        FindPath findPath10 = new FindPath();
        List<ISpace> listOfPotentialSpaces7 = findPath10.findPotentialSpaces(2, map2.getSpaces().get(9));
        assertTrue(listOfPotentialSpaces7.get(0).compareSpaces(map2.getSpaces().get(4)));
        assertFalse(listOfPotentialSpaces7.get(0).compareSpaces(map2.getSpaces().get(1)));

        FindPath findPath11 = new FindPath();
        List<ISpace> listOfPotentialSpaces8 = findPath11.findPotentialSpaces(3, map2.getSpaces().get(5));
        assertTrue(listOfPotentialSpaces8.get(0).compareSpaces(map2.getSpaces().get(2)));
        assertTrue(listOfPotentialSpaces8.get(1).compareSpaces(map2.getSpaces().get(6)));
        assertTrue(listOfPotentialSpaces8.get(2).compareSpaces(map2.getSpaces().get(9)));
        assertTrue(listOfPotentialSpaces8.get(3).compareSpaces(map2.getSpaces().get(3)));
        assertFalse(listOfPotentialSpaces8.get(2).compareSpaces(map2.getSpaces().get(5)));
    }

    @Test
    public void getPotentialSpaces() throws Exception {
        IMap map3 = new MockMap();
        FindPath findpath = new FindPath();
        findpath.findPotentialSpaces(2,map3.getSpaces().get(0));
        assertTrue(findpath.getPotentialSpaces().get(0).compareSpaces(map3.getSpaces().get(2)));
    }

    @Test
    public void getPotentialStations() throws Exception {
        IMap map4 = new MockMap();
        FindPath findPath1 = new FindPath();
        findPath1.findPotentialStations((Station) map4.getSpaces().get(3));
        assertTrue(findPath1.getPotentialStations().get(0).compareSpaces(map4.getSpaces().get(9)));
        assertTrue(findPath1.getPotentialStations().get(1).compareSpaces(map4.getSpaces().get(10)));
        assertFalse(findPath1.getPotentialStations().get(0).compareSpaces(map4.getSpaces().get(3)));

        FindPath findPath2 = new FindPath();
        findPath2.findPotentialStations((Station) map4.getSpaces().get(9));
        assertTrue(findPath2.getPotentialStations().get(0).compareSpaces(map4.getSpaces().get(3)));
        assertFalse(findPath2.getPotentialStations().get(0).compareSpaces(map4.getSpaces().get(10)));
    }
}

