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
