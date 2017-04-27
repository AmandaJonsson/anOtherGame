import Objects.Spaces;
import Objects.Station;

public class Tools {

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

    public void nextTurn(){

    }

}
