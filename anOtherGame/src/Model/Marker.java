/**
 * @author Amanda, Miranda
 * Revised by: *name*
 * Responsibility:
 * Used by:
 * Uses: IPlayer, IDice, IMap
 */


package Model;

import Model.Intefaces.IMarker;

public abstract class Marker implements IMarker {
    boolean isTurned = false;
    private IMarker marker;

    public Marker(){}

    public Marker(IMarker marker) {
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


}
