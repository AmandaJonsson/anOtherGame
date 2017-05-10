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


    

}
