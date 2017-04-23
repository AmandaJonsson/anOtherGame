package Controllers;

import Objects.MoneyMarker;
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

    public int updateBudget(int value) {

        //marker  ==  this.position.getMarker()?
        if (marker.equals(MoneyMarker.TypeOfMarkers.BLANK)){
            return player.budget;
        } else {
            return player.budget + value;
        }

    }

    public int payTicket(int ticket){
        return player.budget - ticket;
    }
}
