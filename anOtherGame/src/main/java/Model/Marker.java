/**
 * @author Amanda, Miranda
 * Revised by: *name*
 * Responsibility:
 * Used by:
 * Uses: IPlayer, IDice, IMap
 */


package Model;

import Model.Intefaces.IMarker;
import Model.Intefaces.IStation;
import event.Event;
import event.EventBus;

public abstract class Marker implements IMarker {
    boolean isTurned = false;
    private IMarker marker;
    IStation stationThatHasMarker;

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
        EventBus.BUS.publish(new Event(Event.Tag.MARKER_FLIPPED,this));
    }

    public IStation getStation(){
        return stationThatHasMarker;
    }

    public void setStation(IStation station){
        stationThatHasMarker = station;
    }


}
