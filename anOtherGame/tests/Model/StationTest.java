package Model;

import org.junit.Test;

import static org.junit.Assert.*;


public class StationTest {
    Station station = new Station("Stockholm", 1, 2);
    String name = "Stockholm";
    Marker marker = new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY);



    Marker rubyMarker = new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY);


    @Test
    public void testGetMarker() throws Exception {
        station.setMarker(rubyMarker);
        assertTrue(station.getMarker().equals(rubyMarker));    // egen equals metod!
    }

    @Test
    public void testGetName() throws Exception {
        assertTrue(station.getName().equals(name));
    }

    @Test
    public void testHasMarker() throws Exception {

        station.setMarker(marker);
        assertTrue(station.hasMarker() != marker.isMarkerTurned());
    }

    @Test
    public void testTurnMarker() throws Exception {
        station.setMarker(marker);
        station.turnMarker();
        assertTrue(marker.isMarkerTurned());

    }

    @Test
    public void testSetMarker() throws Exception {
        station.setMarker(marker);
        assertTrue(station.getMarker().equals(marker));     //egen equals metod!!
    }

    @Test
    public void testSetBoatStation() throws Exception {
        station.setBoatStation(true);
        assertTrue(station.getIsBoatStation());
    }

    @Test
    public void testGetIsBoatStation() throws Exception {
        station.setBoatStation(false);
        assertFalse(station.getIsBoatStation());
    }

    @Test
    public void testSetTramStation() throws Exception {
        station.setTramStation(true);
        assertTrue(station.getIsTramStation());
    }

    @Test
    public void testGetIsTramStation() throws Exception {
        station.setTramStation(false);
        assertFalse(station.getIsTramStation());
    }

    @Test
    public void testSetStart() throws Exception {
        station.setStart(true);
        assertTrue(station.isStart());
    }

    @Test
    public void testIsStart() throws Exception {

        station.setStart(false);
        assertFalse(station.isStart());
    }

   /* @Test
    public void toString() {
    }*/

}
