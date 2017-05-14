package Model.Intefaces;


import Model.Station;

import java.util.ArrayList;
import java.util.List;

public interface IMap {
   boolean createStations();
    void addSpaces(ISpace space);
    ArrayList<ISpace> getSpaces();
    void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<Station> stations);

}

