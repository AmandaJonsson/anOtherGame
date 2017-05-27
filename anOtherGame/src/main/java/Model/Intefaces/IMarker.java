/**
 * @author Maja
 * Revised by: *name*
 * Responsibility: Interface to the Marker class.
 * Used by: Map, MoneyMarker, OtherMarker, Space, Station
 * Uses:
 */

package Model.Intefaces;

public interface IMarker {

    boolean isMarkerTurned();
    void setMarkerToTurned();
    int getMarkerValue(IMarker marker);
    void getOtherMarkerValue(IMarker marker);
}
