/**
 * @author Allex and Amanda
 * Revised by: *name*
 * Responsibility: Creates all stations and spaces on the map and places a random marker at each station.
 * Used by: TheLostKitten
 * Uses: IMap, ISpace, IStation, Space, Station, Marker, MoneyMarker and OtherMarker
 */

package Model;

import Model.Intefaces.IMap;
import Model.Intefaces.IMarker;
import Model.Intefaces.ISpace;
import Model.Intefaces.IStation;

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
/*
        //Bicycle paths.
        slottskogen.getController().addPath(this, linne);
        slottskogen.getController().addPath(this, botaniska);
        slottskogen.getController().addPath(this, masthuggskykan);
        slottskogen.getController().addPath(this, slottskogsvallen);
        chLindholmen.getController().addPath(this, lindholmen);
        chLindholmen.getController().addPath(this, slottsberget);
        operan.getController().addPath(this, stenpiren);
        operan.getController().addPath(this, nordstan);
        emilsborg.getController().addPath(this, guldheden);
        emilsborg.getController().addPath(this, olofshojd);
        vasaplatsen.getController().addPath(this, linne);
        vasaplatsen.getController().addPath(this, ullevi);
        hjbrantings.getController().addPath(this, frihamnen);
        ramberget.getController().addPath(this, chLindholmen);
        ramberget.getController().addPath(this, lundby);
        nordstan.getController().addPath(this, central);
        nordstan.getController().addPath(this, domkyrkan);
        nordstan.getController().addPath(this, stenpiren);
        klippan.getController().addPath(this, ostindiegatan);
        chalmers.getController().addPath(this, guldheden);
        chalmers.getController().addPath(this, emilsborg);
        chalmers.getController().addPath(this, sahlgrenska);
        guldheden.getController().addPath(this, sahlgrenska);
        botaniska.getController().addPath(this, sahlgrenska);
        botaniska.getController().addPath(this, slottskogsvallen);
        */
        createSpaces(slottskogen, linne, null, 0, 0);
        createSpaces(slottskogen, botaniska, null, 0, 0);
        createSpaces(masthuggskykan,slottskogen,  null, 0, 0);
        createSpaces(slottskogen, slottskogsvallen, null, 0, 0);
        createSpaces(chLindholmen, lindholmen, null, 0, 0);
        createSpaces(chLindholmen, slottsberget, null, 0, 0);
        createSpaces(operan, stenpiren, null, 0, 0);
        createSpaces(operan, nordstan, null, 0, 0);
        createSpaces(emilsborg, guldheden, null, 0, 0);
        createSpaces(emilsborg, olofshojd, null, 0, 0);

/*


        //Tram paths.
        //hjbrantings.getController().addTramPath(this, lundby);
        //hjbrantings.getController().addTramPath(this, ramberget);
        /*frihamnen.getController().addTramPath(this, chLindholmen);
        eriksberg.getController().addTramPath(this, lundby);
        frihamnen.getController().addTramPath(this, nordstan);
        central.getController().addTramPath(this, ullevi);
        domkyrkan.getController().addTramPath(this, jarntorget);
        jarntorget.getController().addTramPath(this, masthuggskykan);
        eriksberg.getController().addTramPath(this, lundby);
        masthuggskykan.getController().addTramPath(this, ostindiegatan);
        jarntorget.getController().addTramPath(this, linne);
        linne.getController().addTramPath(this, botaniska);
        slottskogsvallen.getController().addTramPath(this, ostindiegatan);
        chalmers.getController().addTramPath(this, liseberg);
        liseberg.getController().addTramPath(this, ullevi);
        liseberg.getController().addTramPath(this, olofshojd);
        frihamnen.getController().addTramPath(this, ringon);
        central.getController().addTramPath(this, redbergsplatsen);
        liseberg.getController().addTramPath(this, redbergsplatsen);
        vasaplatsen.getController().addTramPath(this, domkyrkan);
        vasaplatsen.getController().addTramPath(this, chalmers);*/

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
        createSpaces(hjbrantings,lundby,  null, 0, 0);
        createSpaces(hjbrantings, ramberget, null, 0, 0);
        createSpaces(frihamnen, chLindholmen, null, 0, 0);
        createSpaces(eriksberg,lundby, null, 0, 0);
        createSpaces(frihamnen, nordstan, null, 0, 0);
        createSpaces(central, ullevi, null, 0, 0);
        createSpaces(domkyrkan, jarntorget, null, 0, 0);
        createSpaces(masthuggskykan, jarntorget, null, 0, 0);
        createSpaces(eriksberg, lundby, null, 0, 0);
        createSpaces(masthuggskykan, ostindiegatan, null, 0, 0);
        createSpaces(jarntorget, linne, null, 0, 0);
        createSpaces(botaniska, linne, null, 0, 0);
        createSpaces(slottskogsvallen, ostindiegatan, null, 0, 0);
        createSpaces(chalmers,liseberg, null, 0, 0);
        createSpaces( ullevi,liseberg, null, 0, 0);
        createSpaces(liseberg, olofshojd, null, 0, 0);
        createSpaces(liseberg, redbergsplatsen, null, 0, 0);
        createSpaces(central, redbergsplatsen, null, 0, 0);
        createSpaces(frihamnen, ringon, null, 0, 0);
        createSpaces(domkyrkan, vasaplatsen, null, 0, 0);
        createSpaces(chalmers,vasaplatsen, null, 0, 0);


        //adding some missing spaces that sould connect the map!
        ISpace space1 = new Space(65,35);
        space1.addAdjacentSpace(nordstan);
        space1.addAdjacentSpace(central);
        nordstan.addAdjacentSpace(space1);
        central.addAdjacentSpace(space1);
        spaces.add(space1);

        ISpace space2 = new Space(58,83);
        spaces.add(space2);
        ISpace space3 = new Space(62,84);
        spaces.add(space3);

        sahlgrenska.addAdjacentSpace(space2);
        space2.addAdjacentSpace(sahlgrenska);

        space3.addAdjacentSpace(space2);
        space2.addAdjacentSpace(space3);

        space3.addAdjacentSpace(guldheden);
        guldheden.addAdjacentSpace(space3);

        ISpace space4 = new Space(50,15);
        spaces.add(space4);
        space4.addAdjacentSpace(hjbrantings);
        space4.addAdjacentSpace(frihamnen);
        hjbrantings.addAdjacentSpace(space4);
        frihamnen.addAdjacentSpace(space4);

        ISpace space5 = new Space(49,81);
        spaces.add(space5);
        space5.addAdjacentSpace(botaniska);
        space5.addAdjacentSpace(sahlgrenska);
        botaniska.addAdjacentSpace(space5);
        sahlgrenska.addAdjacentSpace(space5);

        ISpace space6 = new Space(9,69);
        spaces.add(space6);
        space6.addAdjacentSpace(klippan);
        space6.addAdjacentSpace(ostindiegatan);
        klippan.addAdjacentSpace(space6);
        ostindiegatan.addAdjacentSpace(space6);

        ISpace space7 = new Space(55,39);
        spaces.add(space7);
        space7.addAdjacentSpace(stenpiren);
        space7.addAdjacentSpace(nordstan);
        stenpiren.addAdjacentSpace(space7);
        nordstan.addAdjacentSpace(space7);

        ISpace space8 = new Space(58,34);
        spaces.add(space8);
        space8.addAdjacentSpace(operan);
        space8.addAdjacentSpace(nordstan);
        operan.addAdjacentSpace(space8);
        nordstan.addAdjacentSpace(space8);

        ISpace space9 = new Space(32,42);
        spaces.add(space9);
        space9.addAdjacentSpace(lindholmen);
        space9.addAdjacentSpace(chLindholmen);
        lindholmen.addAdjacentSpace(space9);
        chLindholmen.addAdjacentSpace(space9);

        ISpace space10 = new Space(27,43);
        spaces.add(space10);
        space10.addAdjacentSpace(slottsberget);
        space10.addAdjacentSpace(chLindholmen);
        slottsberget.addAdjacentSpace(space10);
        chLindholmen.addAdjacentSpace(space10);

        ISpace space11 = new Space(71,84);
        spaces.add(space11);
        space11.addAdjacentSpace(emilsborg);
        space11.addAdjacentSpace(guldheden);
        emilsborg.addAdjacentSpace(space11);
        guldheden.addAdjacentSpace(space11);



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

