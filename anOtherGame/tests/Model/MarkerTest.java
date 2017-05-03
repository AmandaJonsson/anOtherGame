package Model;

import org.junit.Test;
import static org.junit.Assert.*;
/**
 * Created by amandajonsson on 2017-05-02.
 */
public class MarkerTest {

    @Test
    public void testMarker(){
        MoneyMarker mark = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
        assertTrue(mark.getMarkerType() == MoneyMarker.TypeOfMarkers.TOPAZ);
        assertFalse(mark.getMarkerType()== MoneyMarker.TypeOfMarkers.RUBY);

        }
}
