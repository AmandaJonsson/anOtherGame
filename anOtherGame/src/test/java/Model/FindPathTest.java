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
import static org.junit.Assert.*;


public class FindPathTest {
    @Test
    public void findPotentialStations() throws Exception {
        IMap map1 = new MockMap();
        FindPath findPath = new FindPath();
        findPath.findPotentialStations((Station) map1.getSpaces().get(3));
        System.out.println(findPath.findPotentialStations((Station) map1.getSpaces().get(3)));


        if(map1.getSpaces().get(3) instanceof IStation){
            System.out.println("hej");
        }

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

