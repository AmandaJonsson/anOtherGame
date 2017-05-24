/**
 * @author Miranda
 * Revised by: *name*
 * Responsibility: A help class to calculate possible paths.
 * Used by: TheLostKitten
 * Uses: ISpace
 */

package Model;

import Model.Intefaces.ISpace;
import java.util.ArrayList;
import java.util.List;

public class FindPath {

    //TODO right now this class does not handle that special case whit BoatStations!
    //TODO one shouldn't be able to pass those -> has to stop at next BoatStation even though dice is higher

    List<ISpace> visitedSpaces = new ArrayList<ISpace>();
    List<ISpace> potentialSpaces = new ArrayList<ISpace>();


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


    public static void printListOfSpaces(List<ISpace> spaces) {
        for (int i = 0; i < spaces.size(); i++) {
            System.out.println(spaces.get(i).toString());
        }
    }

}