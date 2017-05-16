package Model;

/**
 * Created by amandajonsson on 2017-05-16.
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class MoneyMarkerTest {

    MoneyMarker markT = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
    MoneyMarker markE = new MoneyMarker(MoneyMarker.TypeOfMarkers.EMERALD);
    MoneyMarker markR = new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY);
    MoneyMarker markB = new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);

    @Test
    public void testMoneyMarkers() {

        assertTrue(markT.getMarkerType() == MoneyMarker.TypeOfMarkers.TOPAZ);
        assertFalse(markT.getMarkerType() == MoneyMarker.TypeOfMarkers.RUBY);

        assertTrue(markE.getMarkerType() == MoneyMarker.TypeOfMarkers.EMERALD);
        assertFalse(markE.getMarkerType() == MoneyMarker.TypeOfMarkers.TOPAZ);

        assertTrue(markR.getMarkerType() == MoneyMarker.TypeOfMarkers.RUBY);
        assertFalse(markR.getMarkerType() == MoneyMarker.TypeOfMarkers.EMERALD);

        assertTrue(markB.getMarkerType() == MoneyMarker.TypeOfMarkers.BLANK);
        assertFalse(markB.getMarkerType() == MoneyMarker.TypeOfMarkers.RUBY);

    }

    @Test
    public void testMoneymarkerValue(){

        assertTrue(markT.getMarkerValue(markT) == 3000);
        assertTrue(markE.getMarkerValue(markE) == 4000);
        assertTrue(markR.getMarkerValue(markR) == 5000);
        assertTrue(markB.getMarkerValue(markB) == 0);
        assertFalse(markT.getMarkerValue(markT) == 7000);
        assertFalse(markE.getMarkerValue(markE) == 1000);
        assertFalse(markR.getMarkerValue(markR) == 4000);
        assertFalse(markB.getMarkerValue(markB) == 500);

    }
}
