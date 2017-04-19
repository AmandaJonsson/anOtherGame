package Objects;


public abstract class Markers {

    boolean isTurned;

    //Method to get status of a marker, turned or not turned
    //Method will return false if marker is turned
    public boolean isMarkerTurned() {
        if(isTurned == true)
            return false;
        else
            return true;
    }

    //Method to set status of marker, when marker is turned the variable 'isTurned' is set to true
    public void setMarkerToTurned() {
        isTurned = true;
    }


}
