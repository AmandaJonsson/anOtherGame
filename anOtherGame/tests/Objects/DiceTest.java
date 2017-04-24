package Objects;


import static junit.framework.TestCase.assertTrue;

public class DiceTest {

    @Test
    public void testRoll() throws Exception {
        Dice dice = new Dice();
        assertTrue(dice.roll() > 0 || dice.roll() < 7);
    }
}