/**
 * @author Maja
 * Revised by: *name*
 * Responsibility: Interface to the Space class.
 * Used by: Map, IMap, ITheLostKitten
 * Uses:
 */

package Model.Intefaces;

import java.util.List;

public interface ISpace {
    void addAdjacentSpace(ISpace space) ;
    List<ISpace> getAdjacentSpaces();
    int getX();
    int getY();
    boolean compareSpaces(ISpace space);
    String toString();
}
