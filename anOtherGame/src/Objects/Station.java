package Objects;



public class Station extends Spaces{
    Markers marker;

    public Station(String name, int x, int y, Markers marker) {
        super(name, x, y);
        this.marker = marker;
    }

    public Markers getMarker(){
        return marker;
    }

    public boolean hasMarker(){
        if(getMarker().getStatus()==false){ //if getStatus() is false, then isTurned is false, then there still is a marker on the station
            return true;
        }else
            return false;
    }




}