package Objects;

import static org.junit.Assert.*;
import org.junit.Test;

public class DiceTest {

    @Test
    public void testRoll() throws Exception {
        Dice dice = new Dice();
        assertTrue(dice.roll() > 0 || dice.roll() < 7);
    }
}