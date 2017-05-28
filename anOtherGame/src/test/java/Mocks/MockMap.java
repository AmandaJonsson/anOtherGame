package Mocks;

import Model.*;
import Model.Interfaces.IMap;
import Model.Interfaces.ISpace;
import Model.Interfaces.IStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockMap implements IMap {
    List<ISpace> spaces;
    List<IStation> stations;


    public MockMap() {
        spaces = new ArrayList<ISpace>();
        stations = new ArrayList<IStation>();
        ISpace space1 = new Space(3,1);
        ISpace space2 = new Space(3,2);
        ISpace space3 = new Space(3,3);
        IStation space4 = new Station(3,4, "Vasaplatsen",null);
        ISpace space5 = new Space(2,5);
        ISpace space6 = new Space(1,6);
        ISpace space7 = new Space(4,5);
        ISpace space8 = new Space(5,6);
        ISpace space9 = new Space(4,7);
        IStation space10 = new Station(1,7, "Nordstan", null);
        IStation space11 = new Station(6,6, "Kapellplatsen", null);


        space1.addAdjacentSpace(space2);
        space2.addAdjacentSpace(space1);
        space2.addAdjacentSpace(space3);
        space3.addAdjacentSpace(space2);
        space3.addAdjacentSpace(space4);
        space4.addAdjacentSpace(space3);
        space4.addAdjacentSpace(space5);
        space4.addAdjacentSpace(space7);
        space4.addAdjacentSpace(space10);
        space4.addAdjacentSpace(space11);
        space5.addAdjacentSpace(space4);
        space5.addAdjacentSpace(space6);
        space6.addAdjacentSpace(space5);
        space6.addAdjacentSpace(space10);
        space7.addAdjacentSpace(space4);
        space7.addAdjacentSpace(space8);
        space8.addAdjacentSpace(space7);
        space8.addAdjacentSpace(space9);
        space9.addAdjacentSpace(space8);
        space10.addAdjacentSpace(space4);
        space10.addAdjacentSpace(space6);
        space11.addAdjacentSpace(space4);

        spaces.add(space1);
        spaces.add(space2);
        spaces.add(space3);
        spaces.add(space4);
        spaces.add(space5);
        spaces.add(space6);
        spaces.add(space7);
        spaces.add(space8);
        spaces.add(space9);
        spaces.add(space10);
        spaces.add(space11);

        stations.add(space4);
        stations.add(space10);
        stations.add(space11);
    }

    public boolean createSpaces(){
        return true;
    }

    @Override
    public boolean createStations() {
        return false;
    }

    public void addSpaces(ISpace space) {
        spaces.add(space);
    }

    public List<ISpace> getSpaces() {
        return spaces;
    }

    @Override
    public List<IStation> getStations() {
        return null;
    }

    public void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<IStation> stations) {
        ArrayList<Marker> listOfMarkers = new ArrayList<>(stations.size());
    }

    @Override
    public List<ISpace> getStartPositions() {
        return null;
    }

    @Override
    public boolean createSpaces(IStation from, IStation to, ISpace prev, int x, int y) {
        return false;
    }

    @Override
    public boolean checkForMultiples(ISpace space, List<ISpace> listOfSpacesToCheckForMultiples) {
        return false;
    }


    public static void shuffle(ArrayList<Marker> list) {
        int sizeOfList = list.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < sizeOfList; i++) {
            int shuffle = i + random.nextInt(sizeOfList - i);
            swapList(list, i, shuffle);
        }
    }

    public static void swapList (ArrayList<Marker> list, int i, int shuffle){
        Marker supporter = list.get(i);
        list.set(i, list.get(shuffle));
        list.set(shuffle, supporter);
    }
}