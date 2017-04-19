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
        if(getMarker().isMarkerTurned()==false){
            return true;
        }else
            return false;
    }

    public void setMarker(){
        getMarker().setMarkerToTurned();
    }




}