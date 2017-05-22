/*Authors: Maja
Responsibility: Interface to Map
Used by: ITheLostKitten,
Uses:
 */

package Model.Intefaces;

import Model.Marker;
import Model.Station;

import java.util.ArrayList;
import java.util.List;

public interface IMap {
   boolean createStations();
    void addSpaces(ISpace space);
    List<ISpace> getSpaces();
    void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<IStation> stations);
    List<ISpace> getStartPositions();
 //   static void shuffle(ArrayList<IMarker> list){}
 //   static void swapList (ArrayList<IMarker> list, int i, int shuffle){}
    boolean createSpaces(IStation from, IStation to, ISpace prev, int x, int y);
    boolean checkForMultiples(ISpace space, List<ISpace> listOfSpacesToCheckForMultiples);
}

