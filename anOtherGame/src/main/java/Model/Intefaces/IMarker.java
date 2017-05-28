/**
 * @author Maja
 * Revised by: Everybody
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
    IStation getStation();
    void setStation(IStation station);
}
