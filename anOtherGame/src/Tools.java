import Model.ISpace;
import Model.Spaces;
import Model.Station;

import java.util.ArrayList;

public class Tools {

    public boolean canGoByBoat(ISpace position){
        if(position instanceof Station) {
            return ((Station) position).getIsBoatStation();
        }else{
            return false;
        }

    }

    public boolean canGoByTram(ISpace position){
        if(position instanceof Station) {
            return ((Station) position).getIsTramStation();
        }else{
            return false;
        }
    }

    public void nextTurn(){

    }

    public ArrayList<ISpace> findPath(int numberOfDice, ISpace positionOfPlayer){
        ArrayList<ISpace> listOfVisitedSpaces = new ArrayList<ISpace>();
        ArrayList<ISpace> potentialSpaces;

        if(numberOfDice == 1) {
            potentialSpaces = positionOfPlayer.getAdjacentSpaces();
            return potentialSpaces;
        }

        if(numberOfDice == 2){
            listOfVisitedSpaces.add(positionOfPlayer);
            return null;
        }
        return null;
    }

}
