package Objects;


public class Station extends Spaces{
    private Marker marker;
    private String name;
    private boolean isBoatStation;


    public Station(Map map, String name, int x, int y) {
        super("blue", 10, x, y);
        this.name =  name;
        map.addSpaces(this);
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
        if(getMarker().isMarkerTurned()==false){
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

}