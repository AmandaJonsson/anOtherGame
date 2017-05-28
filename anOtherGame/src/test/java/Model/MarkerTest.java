package Model;

/**
 * Created by amandajonsson on 2017-05-28.
 */
import Model.Intefaces.IMarker;
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
