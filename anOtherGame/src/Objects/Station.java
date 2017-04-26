package Objects;


public class Station extends Spaces{
    private Marker marker;
    private final String name;
    private boolean isBoatStation;
    private boolean isTramStation;
    private boolean isStart;


    public Station(Map map, String name, int x, int y) {
        super("blue", 10, x, y);
        this.name =  name;
        map.addSpaces(this);
        isBoatStation = false;
    }

    public Station(int x, int y, String name, Marker marker) {
        super(x, y);
        this.name =  name;
        this.marker = marker;
        isBoatStation = false;
    }

    public Marker getMarker(){
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
        if(!getMarker().isMarkerTurned()){
            return true;
        }else
            return false;
    }

    /*
    Method that changes the status of a marker from not flipped to flipped.
    Will happen when player has flipped the marker on that Station.
     */
    public void setMarker(){
        getMarker().setMarkerToTurned();
    }

    public void setBoatStation(boolean boatStation) {
        isBoatStation = boatStation;
    }

    public boolean getIsBoatStation(){
        return isBoatStation;
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
}