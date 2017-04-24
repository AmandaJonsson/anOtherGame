package Objects;


public class Station extends Spaces{
    private Marker marker;
    private String name;
    

    public Station(int x, int y, String name, Marker marker) {
        super(x, y);
        this.name = name;
        this.marker = marker;
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
}