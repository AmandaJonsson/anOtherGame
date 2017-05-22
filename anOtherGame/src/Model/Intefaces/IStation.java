/*Authors: Maja
Responsibility: Interface to Station.
Used by:
Uses: IMarker
 */

package Model.Intefaces;


public interface IStation extends ISpace {

    IMarker getMarker();
    String getName();

    boolean hasMarker();
    void turnMarker();
    void setMarker(IMarker marker);

    boolean getIsBoatStation();
    boolean getIsTramStation();

    void setTramStation(boolean tramStation);
    void setBoatStation(boolean boatStation);

    void setStart(boolean start);
    boolean isStart();
    String toString();

}

