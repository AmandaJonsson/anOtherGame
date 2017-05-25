package Model;

/**
 * Created by amandajonsson on 2017-05-25.
 */

import Model.Intefaces.IMap;
import Model.Intefaces.ISpace;
import Model.Intefaces.IStation;
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
        System.out.println(map.getStartPositions());
        //assertTrue(map.getStartPositions().contains(lundby));
    }
}
