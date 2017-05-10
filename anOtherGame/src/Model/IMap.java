package Model;

import java.util.ArrayList;
import java.util.List;


public interface IMap {

    boolean createSpaces();

    void addSpaces(Spaces space);

    ArrayList<Spaces> getSpaces();

    void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<Station> stations);



}
