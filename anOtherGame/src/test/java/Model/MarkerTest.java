/**
 * @author Amanda
 * Revised by: Everybody.
 * Responsibility: A test that test methods in the Marker-class
 * Used by: -
 * Uses: IMarker, MoneyMarker
 */

package Model;

import Model.Interfaces.IMarker;
import org.junit.Test;
import static org.junit.Assert.*;

public class MarkerTest {

    IMarker mark = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
    IMarker mark1 = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);


    @Test
    public void testIsMarkerTurned(){
        mark.setMarkerToTurned();
        assertTrue(mark.isMarkerTurned());
        assertFalse(mark1.isMarkerTurned());
    }
}
