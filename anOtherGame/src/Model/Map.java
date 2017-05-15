package Model;

import Model.Intefaces.IMap;
import Model.Intefaces.ISpace;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map implements IMap {
    ArrayList<ISpace> spaces;
    ArrayList<Station> stations;

    public Map() {
        spaces = new ArrayList<ISpace>();
        createStations();
    }

    public boolean createStations() {
        stations= new ArrayList<Station>();
        Station lundby = new Station("Lundby", 7, 14);
        Station ramberget = new Station("Ramberget", 30, 26);
        stations.add(ramberget);
        Station chLindholmen = new Station( "Chalmers Lindholmen", 30, 40);
        stations.add(chLindholmen);
        Station masthuggskykan = new Station( "Masthuggskykan", 31, 57);
        stations.add(masthuggskykan);
        Station lindholmen = new Station( "Lindholmen", 34, 41);
        stations.add(lindholmen);
        Station slottsberget = new Station( "Slottsberget", 23, 45);
        stations.add(slottsberget);
        Station slottskogen = new Station( "Slottskogen", 37, 75);
        stations.add(slottskogen);
        Station slottskogsvallen = new Station( "Slottskogsvallen", 33, 90);
        stations.add(slottskogsvallen);
        Station eriksberg = new Station( "Eriksberg", 10, 49);
        stations.add(eriksberg);
        Station hjbrantings = new Station( "Hjalmar Brantingsplatsen", 47, 15);
        stations.add(hjbrantings);
        Station frihamnen = new Station( "Frihamnen", 53, 15);
        stations.add(frihamnen);
        Station ringon = new Station( "Ringön", 66, 11);
        stations.add(ringon);
        Station operan = new Station( "Operan", 55, 32);
        stations.add(operan);
        Station nordstan = new Station( "Nordstan", 61, 36);
        stations.add(nordstan);
        Station stenpiren = new Station( "Stenpiren", 50, 41);
        stations.add(stenpiren);
        Station central = new Station( "Centralstationen", 68, 34);
        stations.add(central);
        Station domkyrkan = new Station( "Domkyrkan", 58, 43);
        stations.add(domkyrkan);
        Station jarntorget = new Station( "Järntorget", 45, 51);
        stations.add(jarntorget);
        Station ullevi = new Station( "Ullevi (någon av dem)", 78, 41);
        stations.add(ullevi);
        Station chalmers = new Station( "Chalmers", 69, 71);
        stations.add(chalmers);
        Station liseberg = new Station( "Liseberg", 83, 59);
        stations.add(liseberg);
        Station olofshojd = new Station( "Olofshöjd", 85, 74);
        stations.add(olofshojd);
        Station redbergsplatsen = new Station( "Redbergsplatsen", 95, 22);
        Station emilsborg = new Station( "Emilsborg", 76, 82);
        stations.add(emilsborg);
        Station guldheden = new Station( "Guldheden", 65, 84);
        stations.add(guldheden);
        Station linne = new Station( "Linnéplatsen", 45, 68);
        stations.add(linne);
        Station botaniska = new Station( "Botaniska trädgården", 44, 81);
        stations.add(botaniska);
        Station sahlgrenska = new Station( "Sahlgrenska sjukhuset", 54, 82);
        stations.add(sahlgrenska);
        Station ostindiegatan = new Station( "Ostindiegatan", 11, 73);
        stations.add(ostindiegatan);
        Station klippan = new Station( "Klippan", 7, 64);
        stations.add(klippan);
        Station vasaplatsen = new Station( "Vasaplatsen", 63, 56);
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
        //Boat paths.
        lindholmen.setBoatStation(true);
        klippan.setBoatStation(true);
        operan.setBoatStation(true);
        slottsberget.setBoatStation(true);
        eriksberg.setBoatStation(true);
        stenpiren.setBoatStation(true);
        lindholmen.getController().addBoatPath(this, stenpiren);
        klippan.getController().addBoatPath(this, eriksberg);
        slottsberget.getController().addBoatPath(this, klippan);
        operan.getController().addBoatPath(this, eriksberg);*/

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
        eriksberg.setTramStation(true);
        jarntorget.setTramStation(true);
        botaniska.setTramStation(true);
        slottskogsvallen.setTramStation(true);
        liseberg.setTramStation(true);
        botaniska.setTramStation(true);
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
        createSpaces(lundby,hjbrantings,  null, 0, 0);
        createSpaces(hjbrantings, ramberget, null, 0, 0);
        createSpaces(frihamnen, chLindholmen, null, 0, 0);
        createSpaces(lundby, eriksberg, null, 0, 0);
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
        createSpaces(liseberg, ullevi, null, 0, 0);
        createSpaces(liseberg, olofshojd, null, 0, 0);
        createSpaces(liseberg, redbergsplatsen, null, 0, 0);
        createSpaces(central, redbergsplatsen, null, 0, 0);
        createSpaces(frihamnen, ringon, null, 0, 0);
        createSpaces(vasaplatsen, domkyrkan, null, 0, 0);
        createSpaces(chalmers,vasaplatsen, null, 0, 0);

        //Start space.
        redbergsplatsen.setStart(true);
        lundby.setStart(true);
        addMarkers(8, 6, 4, 8, stations); //important sum of spaces = totNOfMarkers
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

        for ( Marker mark : listOfMarkers){
            if(mark instanceof MoneyMarker){
                MoneyMarker mMark= (MoneyMarker) mark;
                System.out.println(mMark.getMarkerType());
            }
            else{
                OtherMarkers oMark = (OtherMarkers) mark;
                System.out.println(oMark.getMarkerType());
            }
        }
        
        for(int i = 0 ; i < stations.size(); i++) {
            stations.get(i).setMarker(listOfMarkers.get(i));
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

    private boolean createSpaces(Station from, Station to, ISpace prev, int x, int y) {
        //init
        if(prev == null){
            prev = from;
            from.addAdjacentSpace(to);
            to.addAdjacentSpace(from);
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
                to.addAdjacentSpace(prev);
            }
            if(!prev.getAdjacentSpaces().contains(to)) {
                prev.addAdjacentSpace(to);
            }
            return true;
        }

        // adds steps for the bicycle path
        if (((from.getX() - x)%7 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%7 == 0&& y!=from.getY() && y!=to.getY())){
            ISpace space = new Space(x, y);
            boolean exists = false;
            for(ISpace spacee : this.getSpaces()){
                if (spacee.getX()-x < 5 && spacee.getX()-x >-5 && spacee.getY()-y < 5 && spacee.getY()-y >-5){
                    System.out.println("jahaja");
                    space = spacee;
                    exists = true;
                }
            }
            space.addAdjacentSpace(prev);
            prev.addAdjacentSpace(space);
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
}

