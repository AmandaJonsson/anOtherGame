package Model;

import Model.Intefaces.ISpace;
import com.sun.xml.internal.xsom.XSWildcard;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by majanyberg on 2017-05-16.
 */
public class PlayerTest {
    String name = "Maja";
    ISpace testGet = new Space(1,1);
    ISpace testSet = new Space(2,3);
    ISpace testUpdate = new Space(3,4);

    ISpace position = new Space(1,1);
    Player player1 = new Player("Amanda", position, 5000);



    // Test for get-methods -----------------------------

    @Test
    public void testGetBalance() throws Exception {
        assertFalse(player1.getBalance() == 4000);
        assertTrue(player1.getBalance() == 5000);

    }

    @Test
    public void testGetPosition() throws Exception {
        assertTrue(player1.getPosition().compareSpaces(testGet));
    }

    @Test
    public void testGetName() throws Exception {
        String correctName = "Amanda";
        assertFalse(player1.getName().equals(name));
        assertTrue(player1.getName().equals(correctName));
    }



    // Test for set-methods -----------------------------

    @Test
    public void testSetTurn() throws Exception {
        player1.setTurn();
        assertTrue(player1.isTurn == true);
    }

    @Test
    public void testSetNotTurn() throws Exception {
        player1.setNotTurn();
        assertTrue(player1.isTurn == false);
    }

    @Test
    public void testSetPosition() throws Exception {
        player1.setPosition(new Space(2,3));
        assertFalse(player1.getPosition().compareSpaces(testGet));
        assertTrue(player1.getPosition().compareSpaces(testSet));
    }

    // Test for other methods -----------------------------

    @Test
    public void testUpdatePosition() throws Exception {
        player1.updatePosition(new Space(3,4));
        assertFalse(player1.getPosition().compareSpaces(testSet));
        assertTrue(player1.getPosition().compareSpaces(testUpdate));

    }

    @Test
    public void testGotTramCard() throws Exception {
        player1.gotTramCard();
        assertTrue(player1.hasTramCard() == true);
    }

    @Test
    public void testUsedTramCard() throws Exception {
        player1.usedTramCard();
        assertFalse(player1.hasTramCard() == true);
    }

    @Test
    public void testHasTramCard() throws Exception {
        //player does not have tramcard, since they got it and then used it
        assertFalse(player1.hasTramCard());
    }

    @Test
    public void testHasCat() throws Exception {
        //player does not have a cat
        assertFalse(player1.hasCat());
    }

    @Test
    public void testRobbedByPickpocket() throws Exception {
        player1.robbedByPickpocket();
        // player should not have 5000 kr as balance
        assertFalse(player1.getBalance() == 5000);
        // player should have 0 kr as balance
        assertTrue(player1.getBalance() == 0);
    }

    @Test
    public void testIncreaseBalance() throws Exception {
        player1.increaseBalance(1000);
        // player should not have 5000 kr as balance
        assertFalse(player1.getBalance() == 0);
        // player should have 6000 kr as balance
        assertTrue(player1.getBalance() == 6000);
    }

    @Test
    public void testDecreaseBalance() throws Exception {
        player1.decreaseBalance(1000);
        // player should not have 5000 kr as balance
        assertFalse(player1.getBalance() == 5000);
        // player should have 4000 kr as balance
        assertTrue(player1.getBalance() == 4000);
    }

    @Test
    public void testPayTicket() throws Exception {
        player1.payTicket(500);
        assertTrue(player1.getBalance() == (5000-500));

    }

    @Test
    public void testGetSkipATurn() throws Exception {
        assertFalse(player1.getSkipATurn());
    }

    @Test
    public void testSkipTurn() throws Exception {
        player1.skipTurn();
        assertTrue(player1.getSkipATurn());
    }

    @Test
    public void testDoneSkippingTurn() throws Exception {
        player1.skipTurn();
        player1.doneSkippingTurn();
        assertFalse(player1.getSkipATurn());
    }

    @Test
    public void testUpdateBudget1() throws Exception {

        Station station1 = new Station("Chalmers",1,1);
        player1.setPosition(station1);

        // Test if the budget increases with 3000 for TOPAZ
        MoneyMarker mMarkerTopaz = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
        station1.setMarker(mMarkerTopaz);
        player1.updateBudget();
        assertTrue(player1.getBalance() == (5000 + 3000));

    }

    @Test
    public void testUpdateBudget2() throws Exception{

        Station station1 = new Station("Chalmers",1,1);
        player1.setPosition(station1);

        // Test if the budget increases with 4000 for EMERALD
        MoneyMarker mMarkerEmerald = new MoneyMarker(MoneyMarker.TypeOfMarkers.EMERALD);
        station1.setMarker(mMarkerEmerald);
        player1.updateBudget();
        assertTrue(player1.getBalance() == (5000 + 4000));
    }


    @Test
    public void testPlayerHasTurn() throws Exception {
        player1.setTurn();
        assertTrue(player1.playerHasTurn());
        player1.setNotTurn();
        assertFalse(player1.playerHasTurn());
    }


}