import Objects.*;

import java.util.LinkedList;

public class TheLostKitten {

    private LinkedList players = new LinkedList();


    public TheLostKitten(){
        Objects.Map map = new Objects.Map();
        Objects.Dice dice = new Objects.Dice();

        Player player1 = new Player("Maja", null, false, false, 5000);



    }

    public void nextTurn(){

    }

    public boolean canGoByBoat(Spaces position){
        if(position.getClass().equals(BoatStation.class)){
            return true;
        }else{
            return false;
        }

    }

    public boolean canGoByTram(Spaces position){
        if(position.getClass().equals(TramStation.class)){
            return true;
        }else{
            return false;
        }
    }

}
