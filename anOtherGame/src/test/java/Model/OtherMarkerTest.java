/**
 * @author Amanda
 * Revised by: Amanda
 * Responsibility: A test that test methods in the OtherMarker-class
 * Used by: -
 * Uses: OtherMarker, Space
 */


package Model;

import org.junit.Test;
import static org.junit.Assert.*;

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
    public void testValueOfOtherMarkers(){
        if(markC.getMarkerType() == OtherMarkers.NoMoneyMarkers.CAT){
            markC.countCat = 1;
        }
        assertEquals(1, markC.getMarkerValue(markC));
        assertTrue(markC.countCat == 1);
        assertFalse(markC.getMarkerValue(markC) == 2);
        assertFalse(markC.countCat == 2);

        if(markTC.getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD){
            markTC.countTramcard = 1;
        }

        assertTrue(markTC.getMarkerValue((markTC)) ==1);
        assertTrue(markTC.countTramcard == 1);
        assertFalse(markTC.getMarkerValue(markTC) == 5);
        assertFalse(markTC.countTramcard == 5);

        if(markP.getMarkerType() == OtherMarkers.NoMoneyMarkers.PICKPOCKET){
            markP.pickpocket = 0;
        }
        assertTrue(markP.getMarkerValue(markP) == 0);
        assertTrue(markP.pickpocket == 0);
        assertFalse(markP.getMarkerValue(markP) == 10);
        assertFalse(markP.pickpocket == 2);
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

