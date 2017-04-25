import Objects.Station;
import Objects.Player;
import Objects.Spaces;

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
        if(position instanceof Station) {
            return ((Station) position).getIsBoatStation();
        }else{
            return false;
        }


    }

    public boolean canGoByTram(Spaces position){
        if(position instanceof Station) {
            return ((Station) position).getIsTramStation();
        }else{
            return false;
        }
    }


}
