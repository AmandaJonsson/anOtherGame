/**
 * @author Amanda.
 * Revised by: Everybody.
 * Responsibility: A test that test methods in the Map-class
 * Used by: -
 * Uses: ISPace, IStation, IMap
 */

package Model;

import Model.Interfaces.IMap;
import Model.Interfaces.ISpace;
import Model.Interfaces.IStation;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MapTest {

    List<ISpace> spaces;
    List<IStation> stations;
    Station lundby = new Station("Lundby", 7, 14);
    Station redbergsplatsen = new Station( "Redbergsplatsen", 95, 22);
    ISpace space = new Space(10,49);
    IMap map;

    public MapTest(){
        spaces=new ArrayList<>();
        stations = new ArrayList<>();
        stations.add(lundby);
        lundby.setStart(true);
        redbergsplatsen.setStart(true);
        stations.add(redbergsplatsen);
        spaces.addAll(stations);
        spaces.add(space);
        map=new Map();
    }

    @Test
    public void testCreateStations(){
        assertTrue(map.createStations()==true);
    }
    @Test
    public void testStation(){

        assertTrue(spaces.get(0) == lundby);
        assertTrue(spaces.get(1) == redbergsplatsen);

    }

    @Test
    public void testGetSpaces(){
        assertTrue(spaces.contains(space));

    }

    @Test
    public void testGetStartPositions(){

        assertTrue(lundby.isStart());
        assertTrue(redbergsplatsen.isStart());
    }
}
