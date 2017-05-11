package Model;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public interface IMap {
    public boolean createSpaces();
    public void addSpaces(ISpace space);
    public ArrayList<ISpace> getSpaces();
    public void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<Station> stations);
}
