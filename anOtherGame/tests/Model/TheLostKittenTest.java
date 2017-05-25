package Model;

/**
 * Created by amandajonsson on 2017-05-25.
 */

import Model.Intefaces.IMarker;
import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.TheLostKitten;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TheLostKittenTest {

    ISpace position = new Space(10,49);
    Player player1 = new Player("Amanda", position, 5000);
    private List<IPlayer> playerList;
    IMarker markM = new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ);
    IMarker markO = new OtherMarkers(OtherMarkers.NoMoneyMarkers.CAT);
    IMarker markT = new OtherMarkers(OtherMarkers.NoMoneyMarkers.TRAMCARD);
    IMarker markP = new OtherMarkers(OtherMarkers.NoMoneyMarkers.PICKPOCKET);
    TheLostKitten kitten;


    public TheLostKittenTest(){
        playerList=new ArrayList<>();
        playerList.add(player1);
        kitten = new TheLostKitten(playerList);

    }

    @Test
    public void testGetListOfPLayers(){
        assertTrue(playerList.contains(player1));
    }

    @Test
    public void testSetNewBudget(){
        Station station1 = new Station("Chalmers",1,1);
        player1.setPosition(station1);
        station1.setMarker(markM);
        kitten.setNewBudget();
        assertTrue(player1.getBalance() == 8000);
        assertFalse(player1.getBalance() == 3000);


        station1.setMarker(markO);
        kitten.setNewBudget();
        assertTrue(player1.getBalance() == 8000);
        assertTrue(player1.setHasCat() == true);
        assertTrue(player1.hasCat() == true);


        station1.setMarker(markT);
        kitten.setNewBudget();
        assertTrue(player1.getBalance() == 8000);
        assertTrue(player1.gotTramCard() == true);
        assertTrue(player1.hasTramCard() == true);


        station1.setMarker(markP);
        kitten.setNewBudget();
        assertTrue(player1.getBalance() == 8000);
        assertTrue(player1.robbedByPickpocket() == true);

    }

    @Test
    public void testCheckIfMarkerIsTurned(){
        markM.setMarkerToTurned();
        assertTrue(kitten.checkIfMarkerIsTurned(markM) == true);
        assertFalse(kitten.checkIfMarkerIsTurned(markO) == true);
    }

}
