package Model;

import Model.Intefaces.ISpace;
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
    boolean hasCat = false;
    boolean hasTramcard = false;
    boolean skipATurn = false;
    boolean isTurn = false;

    ISpace position = new Space(1,1);
    Player player1 = new Player("Amanda", position, 5000);
    Player player2 = new Player(hasTramcard, hasCat, skipATurn, isTurn);


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
        player2.gotTramCard();
        assertTrue(player2.hasTramCard() == true);
    }

    @Test
    public void testUsedTramCard() throws Exception {
        player2.usedTramCard();
        assertFalse(player2.hasTramCard() == true);
    }

    @Test
    public void testHasTramCard() throws Exception {
        assertTrue(player2.hasTramCard() == hasTramcard);
    }

    @Test
    public void testHasCat() throws Exception {
        assertTrue(player2.hasCat() == hasCat);
    }

    @Test
    public void robbedByPickpocket() throws Exception {
    }

    @Test
    public void increaseBalance() throws Exception {
    }

    @Test
    public void decreaseBalance() throws Exception {
    }

    @Test
    public void payTicket() throws Exception {

    }

    @Test
    public void getSkipATurn() throws Exception {
    }

    @Test
    public void skipTurn() throws Exception {
    }

    @Test
    public void doneSkippingTurn() throws Exception {
    }

    @Test
    public void updateBudget() throws Exception {
    }

    @Test
    public void playerHasTurn() throws Exception {
    }


}