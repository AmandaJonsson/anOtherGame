/**
 * @author Miranda
 * Revised by: Everybody.
 * Responsibility: A help class to calculate possible paths.
 * Used by: TheLostKitten
 * Uses: ISpace, Station
 */

package Model;

import Model.Intefaces.ISpace;
import Model.Intefaces.IStation;
import event.Event;
import event.EventBus;

import java.util.ArrayList;
import java.util.List;

public class FindPath{

    List<ISpace> visitedSpaces = new ArrayList<ISpace>();
    List<ISpace> potentialSpaces = new ArrayList<ISpace>();
    List<IStation> potentialStations = new ArrayList<IStation>();

    public List<IStation> findPotentialStations(IStation positionOfPlayer){
        for(int i = 0; i< positionOfPlayer.getAdjacentSpaces().size(); i++){
            if(positionOfPlayer.getAdjacentSpaces().get(i) instanceof IStation) {
                potentialStations.add((IStation) positionOfPlayer.getAdjacentSpaces().get(i));
            }
        }
        EventBus.BUS.publish(new Event(Event.Tag.FIND_TRAMSTATION, this));
        return potentialStations;
    }

    public List<ISpace> findPotentialSpaces(int numberOnDice, ISpace positionOfPlayer) {

        List<ISpace> tempList = new ArrayList<ISpace>();
        potentialSpaces.add(positionOfPlayer);
        for (int i = 0; i < numberOnDice; i++) {
            for (int j = 0; j < potentialSpaces.size(); j++) {
                for (int k = 0; k < potentialSpaces.get(j).getAdjacentSpaces().size(); k++) {
                    if(potentialSpaces.get(j) instanceof Station){
                        if(!(potentialSpaces.get(j).getAdjacentSpaces().get(k) instanceof Station)){
                            tempList.add(potentialSpaces.get(j).getAdjacentSpaces().get(k));
                            tempList = mergeLists(potentialSpaces, tempList);
                        }
                    }
                    else {
                        tempList.add(potentialSpaces.get(j).getAdjacentSpaces().get(k));
                        tempList = mergeLists(potentialSpaces, tempList);
                    }
                }
                visitedSpaces.add(potentialSpaces.get(j));
            }
            potentialSpaces = checkForVisitedSpaces(tempList);
        }
        for (int l = 0; l < visitedSpaces.size(); l++) {
            if (visitedSpaces.get(l) instanceof Station){
                if (!visitedSpaces.get(l).compareSpaces(positionOfPlayer))
                    potentialSpaces.add(visitedSpaces.get(l));
            }
        }
        EventBus.BUS.publish(new Event(Event.Tag.FIND_PATH, this));
        return potentialSpaces;
    }

    private static List<ISpace> mergeLists(List<ISpace> list1, List<ISpace> list2) {
        List<ISpace> newList = new ArrayList<ISpace>();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    private List<ISpace> checkForVisitedSpaces(List<ISpace> list){
        List<ISpace> newList = new ArrayList<ISpace>();
        for (int i = 0; i < list.size(); i++){
            ISpace temp = list.get(i);
            if (!visitedSpaces.contains(temp)){
                newList.add(temp);
            }
        }
        return newList;
    }

    public List<ISpace> getPotentialSpaces() {
        return potentialSpaces;
    }

    public List<IStation> getPotentialStations() {
        return potentialStations;
    }
}
