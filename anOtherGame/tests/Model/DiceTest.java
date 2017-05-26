/**
 * @author Amanda
 * Revised by: Amanda
 * Responsibility: A test that test methods in the Dice-class
 * Used by: -
 * Uses: Dice
 */

package Model;

import org.junit.Test;
import static org.junit.Assert.*;

public class DiceTest {

    @Test
    public void testRoll() throws Exception {
        Dice dice = new Dice();
        assertTrue(dice.roll() > 0 || dice.roll() < 7);
    }
}

