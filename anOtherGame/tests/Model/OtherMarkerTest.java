package Model;

import org.junit.Test;
import static org.junit.Assert.*;

/*Created by amandajonsson on 2017-05-02.*/
public class OtherMarkerTest {

    OtherMarkers markC = new OtherMarkers(OtherMarkers.NoMoneyMarkers.CAT);
    OtherMarkers markP = new OtherMarkers(OtherMarkers.NoMoneyMarkers.PICKPOCKET);
    OtherMarkers markTC = new OtherMarkers(OtherMarkers.NoMoneyMarkers.TRAMCARD);

    Space space;

  @Test
  public void testOtherMarkers(){

      assertTrue(markC.getMarkerType() == OtherMarkers.NoMoneyMarkers.CAT);
      assertFalse(markC.getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD);

      assertTrue(markP.getMarkerType() == OtherMarkers.NoMoneyMarkers.PICKPOCKET);
      assertFalse(markP.getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD);

      assertTrue(markTC.getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD);
      assertFalse(markTC.getMarkerType() == OtherMarkers.NoMoneyMarkers.CAT);
  }


    @Test
    public void testMarkerSpace() {
        if (space instanceof Station) {
            assertTrue(((Station) space).hasMarker());
            assertFalse(((Station) space).hasMarker());
        }
        if (space instanceof Station) {
            assertFalse(!((Station) space).hasMarker());
        }

    }
}

