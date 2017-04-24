package Controllers;

import Objects.MoneyMarker;
import Objects.OtherMarkers;
import Objects.Player;
import Objects.Spaces;

public class PlayerController {

    Player player;

    //fejk marker tills vi skrivit en funktion som heter getMarker
    private MoneyMarker marker = new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);


    public PlayerController(Player player){
        this.player = player;
    }

    public void updatePosition(Spaces newPosition){
        player.position = newPosition;

    }

    public void updateBudget(int value) {

        //marker  ==  this.position.getMarker()?
        if(marker.getClass().equals(MoneyMarker.class)){
            increaseBudget(value);
        } else if(marker.equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
            decreaseBudget(value);
        }

    }

    public int decreaseBudget(int value){
        return player.budget - value;
    }

    public int increaseBudget(int value){
        return player.budget + value;
    }

    public int payTicket(int ticket){
        return player.budget - ticket;
    }
}
