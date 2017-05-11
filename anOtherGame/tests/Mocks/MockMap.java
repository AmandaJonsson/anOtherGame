package Mocks;

import Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MockMap implements IMap {
    ArrayList<ISpace> spaces;


    public MockMap() {
        spaces = new ArrayList<ISpace>();
        ISpace space1 = new Spaces(3,1);
        ISpace space2 = new Spaces(3,2);
        ISpace space3 = new Spaces(3,3);
        ISpace space4 = new Station(3,4, "Vasaplatsen",null);
        //ISpace space4 = new Spaces(3,4); 
        ISpace space5 = new Spaces(2,5);
        ISpace space6 = new Spaces(1,6);
        ISpace space7 = new Spaces(4,5);
        ISpace space8 = new Spaces(5,6);
        ISpace space9 = new Spaces(4,7);


        space1.addAdjacentSpace(space2);
        space2.addAdjacentSpace(space1);
        space2.addAdjacentSpace(space3);
        space3.addAdjacentSpace(space2);
        space3.addAdjacentSpace(space4);
        space4.addAdjacentSpace(space3);
        space4.addAdjacentSpace(space5);
        space4.addAdjacentSpace(space7);
        space5.addAdjacentSpace(space4);
        space5.addAdjacentSpace(space6);
        space6.addAdjacentSpace(space5);
        space7.addAdjacentSpace(space4);
        space7.addAdjacentSpace(space8);
        space8.addAdjacentSpace(space7);
        space8.addAdjacentSpace(space9);
        space9.addAdjacentSpace(space8);

        spaces.add(space1);
        spaces.add(space2);
        spaces.add(space3);
        spaces.add(space4);
        spaces.add(space5);
        spaces.add(space6);
        spaces.add(space7);
        spaces.add(space8);
        spaces.add(space9);
    }

    public boolean createSpaces(){
        return true;
    }

    public void addSpaces(ISpace space) {
        spaces.add(space);
    }

    public ArrayList<ISpace> getSpaces() {
        return spaces;
    }

    public void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<Station> stations) {

        ArrayList<Marker> listOfMarkers = new ArrayList<>(stations.size());
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