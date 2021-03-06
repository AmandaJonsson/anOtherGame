
/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Interface to Map
 * Used by: TheLostKitten, ITheLostKitten, IMap
 * Uses: ISpace, IStation
 */

package Model.Interfaces;

import java.util.List;

public interface IMap {
   boolean createStations();
    void addSpaces(ISpace space);
    List<ISpace> getSpaces();
    List<IStation> getStations();
    void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<IStation> stations);
    List<ISpace> getStartPositions();
    boolean createSpaces(IStation from, IStation to, ISpace prev, int x, int y);
    boolean checkForMultiples(ISpace space, List<ISpace> listOfSpacesToCheckForMultiples);
}

