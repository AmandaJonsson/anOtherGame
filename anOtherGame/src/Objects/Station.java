package Objects;



public class Station extends Spaces{
    Marker marker;
    

    public Station(String name, int x, int y, Marker marker) {
        super(x, y);
        this.marker = marker;
    }

    public Marker getMarker(){
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