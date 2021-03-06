/**
 * @author Allex and Amanda
 * Revised by: Everybody.
 * Responsibility: Creates all stations and spaces on the map and places a random marker at each station.
 * Used by: TheLostKitten
 * Uses: IMap, ISpace, IStation, Space, Station, Marker, MoneyMarker and OtherMarker
 */

package Model;

import Model.Interfaces.IMap;
import Model.Interfaces.IMarker;
import Model.Interfaces.ISpace;
import Model.Interfaces.IStation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements IMap {
    List<ISpace> spaces;
    List<IStation> stations;

    public Map() {
        spaces = new ArrayList<ISpace>();
        createStations();
    }

    public boolean createStations() {
        stations= new ArrayList<IStation>();
        IStation lundby = new Station("Lundby", 7, 14);

        IStation ramberget = new Station("Ramberget", 30, 26);
        stations.add(ramberget);
        IStation chLindholmen = new Station( "Chalmers Lindholmen", 30, 40);
        stations.add(chLindholmen);
        IStation masthuggskykan = new Station( "Masthuggskykan", 31, 57);
        stations.add(masthuggskykan);
        IStation lindholmen = new Station( "Lindholmen", 34, 45);
        stations.add(lindholmen);
        IStation slottsberget = new Station( "Slottsberget", 23, 45);
        stations.add(slottsberget);
        IStation slottskogen = new Station( "Slottskogen", 37, 75);
        stations.add(slottskogen);
        IStation slottskogsvallen = new Station( "Slottskogsvallen", 33, 90);
        stations.add(slottskogsvallen);
        IStation eriksberg = new Station( "Eriksberg", 10, 49);
        stations.add(eriksberg);
        IStation hjbrantings = new Station( "Hjalmar Brantingsplatsen", 47, 15);
        stations.add(hjbrantings);
        IStation frihamnen = new Station( "Frihamnen", 53, 15);
        stations.add(frihamnen);
        IStation ringon = new Station( "Ringön", 66, 11);
        stations.add(ringon);
        IStation operan = new Station( "Operan", 55, 32);
        stations.add(operan);
        IStation nordstan = new Station( "Nordstan", 61, 36);
        stations.add(nordstan);
        IStation stenpiren = new Station( "Stenpiren", 50, 41);
        stations.add(stenpiren);
        IStation central = new Station( "Centralstationen", 68, 34);
        stations.add(central);
        IStation domkyrkan = new Station( "Domkyrkan", 58, 43);
        stations.add(domkyrkan);
        IStation jarntorget = new Station( "Järntorget", 45, 51);
        stations.add(jarntorget);
        IStation ullevi = new Station( "Ullevi (någon av dem)", 78, 41);
        stations.add(ullevi);
        IStation chalmers = new Station( "Chalmers", 69, 71);
        stations.add(chalmers);
        IStation liseberg = new Station( "Liseberg", 83, 59);
        stations.add(liseberg);
        IStation olofshojd = new Station( "Olofshöjd", 85, 74);
        stations.add(olofshojd);
        IStation redbergsplatsen = new Station( "Redbergsplatsen", 95, 22);

        IStation emilsborg = new Station( "Emilsborg", 76, 82);
        stations.add(emilsborg);
        IStation guldheden = new Station( "Guldheden", 65, 84);
        stations.add(guldheden);
        IStation linne = new Station( "Linnéplatsen", 45, 68);
        stations.add(linne);
        IStation botaniska = new Station( "Botaniska trädgården", 44, 81);
        stations.add(botaniska);
        IStation sahlgrenska = new Station( "Sahlgrenska sjukhuset", 54, 82);
        stations.add(sahlgrenska);
        IStation ostindiegatan = new Station( "Ostindiegatan", 11, 73);
        stations.add(ostindiegatan);
        IStation klippan = new Station( "Klippan", 7, 64);
        stations.add(klippan);
        IStation vasaplatsen = new Station( "Vasaplatsen", 63, 56);
        stations.add(vasaplatsen);
        spaces.addAll(stations);
        spaces.add(redbergsplatsen);
        spaces.add(lundby);

        createSpaces(linne, slottskogen, null, 0, 0);
        createSpaces(slottskogen, botaniska, null, 0, 0);
        createSpaces(masthuggskykan,slottskogen,  null, 0, 0);
        createSpaces(slottskogen, slottskogsvallen, null, 0, 0);
        createSpaces(chLindholmen, lindholmen, null, 0, 0);
        createSpaces(chLindholmen, slottsberget, null, 0, 0);
        createSpaces(operan, stenpiren, null, 0, 0);
        createSpaces(operan, nordstan, null, 0, 0);
        createSpaces(emilsborg, guldheden, null, 0, 0);
        createSpaces(emilsborg, olofshojd, null, 0, 0);


        hjbrantings.setTramStation(true);
        frihamnen.setTramStation(true);
        eriksberg.setTramStation(true);
        central.setTramStation(true);
        domkyrkan.setTramStation(true);
        masthuggskykan.setTramStation(true);
        jarntorget.setTramStation(true);
        botaniska.setTramStation(true);
        slottskogsvallen.setTramStation(true);
        liseberg.setTramStation(true);
        vasaplatsen.setTramStation(true);
        chalmers.setTramStation(true);
        ringon.setTramStation(true);
        redbergsplatsen.setTramStation(true);
        olofshojd.setTramStation(true);
        ostindiegatan.setTramStation(true);
        linne.setTramStation(true);
        ramberget.setTramStation(true);
        lundby.setTramStation(true);
        ullevi.setTramStation(true);
        chLindholmen.setTramStation(true);
        createSpaces(hjbrantings, lundby, null, 0, 0);
        createSpaces(ramberget,hjbrantings,  null, 0, 0);
        createSpaces( chLindholmen,frihamnen, null, 0, 0);
        createSpaces(eriksberg,lundby, null, 0, 0);
        createSpaces(frihamnen, nordstan, null, 0, 0);
        createSpaces(central, ullevi, null, 0, 0);
        createSpaces(domkyrkan, jarntorget, null, 0, 0);
        createSpaces(masthuggskykan, jarntorget, null, 0, 0);
        createSpaces(eriksberg, lundby, null, 0, 0);
        createSpaces(masthuggskykan, ostindiegatan, null, 0, 0);
        createSpaces(jarntorget, linne, null, 0, 0);
        createSpaces(linne,botaniska,  null, 0, 0);
        createSpaces(slottskogsvallen, ostindiegatan, null, 0, 0);
        createSpaces(chalmers,liseberg, null, 0, 0);
        createSpaces( ullevi,liseberg, null, 0, 0);
        createSpaces(liseberg, olofshojd, null, 0, 0);
        createSpaces(liseberg, redbergsplatsen, null, 0, 0);
        createSpaces(central, redbergsplatsen, null, 0, 0);
        createSpaces(frihamnen, ringon, null, 0, 0);
        createSpaces(domkyrkan, vasaplatsen, null, 0, 0);
        createSpaces(chalmers,vasaplatsen, null, 0, 0);
        createSpaces(klippan,ostindiegatan, null, 0, 0);
        createSpaces(botaniska,sahlgrenska, null, 0, 0);
        createSpaces(sahlgrenska,guldheden, null, 0, 0);
        createSpaces(chalmers,sahlgrenska, null, 0, 0);
        createSpaces(nordstan,central, null, 0, 0);
        createSpaces(nordstan,domkyrkan, null, 0, 0);
        createSpaces(nordstan,stenpiren, null, 0, 0);
        createSpaces(hjbrantings,frihamnen, null, 0, 0);

        //Start space.
        redbergsplatsen.setStart(true);
        lundby.setStart(true);
        addMarkers(8, 6, 4, 8, stations); //important sum of spaces = totNOfMarkers

        return true;
    }

    public void addSpaces(ISpace space) {
        spaces.add(space);
    }

    public List<ISpace> getSpaces() {
        return spaces;
    }

    public List<IStation> getStations(){
        return stations;
    }

    public void addMarkers(double noTopaz, double noEmerald, double nOfRubys, double nOfBlanks, List<IStation> stations) {

        List<IMarker> listOfMarkers = new ArrayList<IMarker>(stations.size());

        for (int i = 0; i < noTopaz; i++)
            listOfMarkers.add(new MoneyMarker(MoneyMarker.TypeOfMarkers.TOPAZ));
        for (int i = 0; i < noEmerald; i++)
            listOfMarkers.add(new MoneyMarker(MoneyMarker.TypeOfMarkers.EMERALD));
        for (int i = 0; i < nOfRubys; i++)
            listOfMarkers.add(new MoneyMarker(MoneyMarker.TypeOfMarkers.RUBY));
        for (int i = 0; i < nOfBlanks; i++)
            listOfMarkers.add(new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK));

        listOfMarkers.add(new OtherMarkers(OtherMarkers.NoMoneyMarkers.CAT));
        listOfMarkers.add(new OtherMarkers(OtherMarkers.NoMoneyMarkers.PICKPOCKET));
        listOfMarkers.add(new OtherMarkers(OtherMarkers.NoMoneyMarkers.TRAMCARD));

        shuffle(listOfMarkers);

        for(int i = 0 ; i < stations.size(); i++) {
            stations.get(i).setMarker(listOfMarkers.get(i));
            listOfMarkers.get(i).setStation(stations.get(i));
        }
    }

    public ArrayList<ISpace> getStartPositions(){

        ArrayList<ISpace> startPositions = new ArrayList<ISpace>();
        for (int i=0; i<spaces.size();i++){
            if(spaces.get(i) instanceof Station ){
                if(((Station) spaces.get(i)).isStart()){
                    startPositions.add(spaces.get(i));
                }
            }
        }
        return startPositions;
    }

    public static void shuffle(List<IMarker> list) {
        int sizeOfList = list.size();
        Random random = new Random();
        random.nextInt();
        for (int i = 0; i < sizeOfList; i++) {
            int shuffle = i + random.nextInt(sizeOfList - i);
            swapList(list, i, shuffle);
        }
    }

    public static void swapList (List<IMarker> list, int i, int shuffle){
        IMarker supporter = (IMarker) list.get(i);
        list.set(i, list.get(shuffle));
        list.set(shuffle, supporter);

    }

    public boolean createSpaces(IStation from, IStation to, ISpace prev, int x, int y) {
        //init


        if(prev == null){
            prev = from;
            if(!checkForMultiples(to, from.getAdjacentSpaces())){
                if(!from.compareSpaces(to)){
                    from.addAdjacentSpace(to);
                }
            }
            if(!checkForMultiples(from, to.getAdjacentSpaces())){
                if(!to.compareSpaces(from)){
                    to.addAdjacentSpace(from);
                }
            }
        }
        if(x == 0){
            x = from.getX();
        }
        if(y == 0){
            y = from.getY();
        }
        //base case
        if (x == to.getX() && y== to.getY()){
            if(!to.getAdjacentSpaces().contains(prev)) {
                if(!to.compareSpaces(prev)){
                    to.addAdjacentSpace(prev);
                }
            }
            if(!prev.getAdjacentSpaces().contains(to)) {
                if(!prev.compareSpaces(to)){
                    prev.addAdjacentSpace(to);
                }
            }
            return true;
        }

        // adds steps for the bicycle path
        if (((from.getX() - x)%7 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%7 == 0&& y!=from.getY() && y!=to.getY())){
            ISpace space = new Space(x, y);
            boolean exists = false;
            for(ISpace spacee : this.getSpaces()){
                if (spacee.getX()-x < 5 && spacee.getX()-x >-5 && spacee.getY()-y < 5 && spacee.getY()-y >-5){
                    space = spacee;
                    exists = true;
                }
            }
            if(!checkForMultiples(prev, space.getAdjacentSpaces())){
                if(!space.compareSpaces(prev)){
                    space.addAdjacentSpace(prev);
                }
            }

            if(!checkForMultiples(space, prev.getAdjacentSpaces())){
                if(!prev.compareSpaces(space)){
                    prev.addAdjacentSpace(space);
                }
            }

            if (!exists) {
                this.addSpaces(space);
            }
            prev = space;
        }
        if (x < to.getX()){
            if (y==to.getY()){
                return createSpaces(from, to, prev,x+1, y);
            }
            if (y<to.getY()){
                return createSpaces(from, to, prev, x+1,y+1);
            }
            if (y>to.getY()){
                return createSpaces(from, to, prev, x+1,y-1);
            }
        }
        if (x > to.getX()){
            if (y==to.getY()){
                return createSpaces(from, to,prev,x-1, y);
            }
            if (y<to.getY()){
                return createSpaces(from, to, prev, x-1,y+1);
            }
            if (y>to.getY()){
                return createSpaces(from, to, prev, x-1,y-1);
            }
        }
        if (x==to.getX()){
            if (y<to.getY()){
                return createSpaces(from, to, prev, x,y+1);
            }
            if (y>to.getY()){
                return createSpaces(from, to, prev, x,y-1);
            }
        }

        return false;
    }

    public boolean checkForMultiples(ISpace space, List<ISpace> listOfSpacesToCheckForMultiples){
        if(listOfSpacesToCheckForMultiples.contains(space)){
            return true;
        }else{
            return false;
        }
    }
}

