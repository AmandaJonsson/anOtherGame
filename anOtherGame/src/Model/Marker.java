package Model;

public abstract class Marker {
    boolean isTurned = false;
    private Marker marker;

    public Marker(){}

    public Marker(Marker marker) {
        this.marker = marker;
    }

    /*
    Method that checks if a Marker is turned.
    Returns true if marker is turned.
     */
    public boolean isMarkerTurned() {
        if(isTurned == true)
            return true;
        else
            return false;
    }


    /*
    Method that sets the status of a Marker to turned.
    This shall happen when player flipped the marker.
     */
    public void setMarkerToTurned() {
        isTurned = true;
    }

    /*
    Method that returns the "action" the Marker.
    Must be implemented by all classes extending Marker.
     */
    public abstract void Markervalue();

}
