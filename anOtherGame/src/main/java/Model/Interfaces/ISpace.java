/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Interface to the Space class.
 * Used by: Map, IMap, ITheLostKitten
 * Uses:
 */

package Model.Interfaces;

import java.util.List;

public interface ISpace {
    void addAdjacentSpace(ISpace space) ;
    List<ISpace> getAdjacentSpaces();
    int getX();
    int getY();
    boolean compareSpaces(ISpace space);
    String toString();
}
