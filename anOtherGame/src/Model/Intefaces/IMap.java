package Model.Intefaces;

import java.util.List;

public interface IMap {
   boolean createStations();
    void addSpaces(ISpace space);
    List<ISpace> getSpaces();
    void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<IStation> stations);
    List<ISpace> getStartPositions();
}

