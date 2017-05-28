/**
 * @author Miranda
 * Responsibility: The logic behind the stations.
 * Used by:
 * Uses: IMarker
 */



package Model;


import Model.Intefaces.IMarker;
import Model.Intefaces.IStation;

public class Station extends Space implements IStation {
    private IMarker marker;
    private final String name;
    private boolean isBoatStation;
    private boolean isTramStation;
    private boolean isStart;


    public Station( String name, int x, int y) {
        super(x, y);
        this.name =  name;
        isBoatStation = false;
        isTramStation = false;
    }

    public Station( int x, int y,String name, IMarker marker) {
        super(x, y);
        this.name =  name;
        this.marker = marker;
        isBoatStation = false;
        isTramStation = false;
    }

    public IMarker getMarker(){
        return marker;
    }

    public String getName(){
        return name;
    }

    /*
    Method that checks whether there still is a Marker on the Station.
    If method returns true than marker has not been turned and can still be turned!
     */
    public boolean hasMarker(){
        if(!isStart) {
            if (!getMarker().isMarkerTurned()) {
                return true;
            }

        }
        return false;

    }

    /*
    Method that changes the status of a marker from not flipped to flipped.
    Will happen when player has flipped the marker on that Station.
     */
    public void turnMarker(){
        marker.setMarkerToTurned();
    }

    public void setMarker(IMarker marker) {
        this.marker = marker;
    }


    public void setTramStation(boolean tramStation){
        isTramStation = tramStation;
    }

    public boolean getIsTramStation(){
        return isTramStation;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public boolean isStart() {
        return isStart;
    }

    @Override
    public String toString(){
        return getName() + "";
    }
}