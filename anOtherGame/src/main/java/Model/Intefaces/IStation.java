
/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Interface to Station.
 * Used by:
 * Uses: IMarker
 */
package Model.Intefaces;


public interface IStation extends ISpace {

    IMarker getMarker();
    String getName();

    boolean hasMarker();
    void turnMarker();
    void setMarker(IMarker marker);

    boolean getIsTramStation();

    void setTramStation(boolean tramStation);

    boolean isStart();
    String toString();

    void setStart(boolean start);

}

