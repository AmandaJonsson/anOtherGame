package Objects;


import Controllers.MapController;
import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.HPos;
import javafx.scene.Group;
import javafx.scene.layout.*;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

import static javafx.geometry.VPos.CENTER;

public class Map{


    ArrayList<Spaces> spaces;

    public Map() {
        spaces = new ArrayList<Spaces>();
    }

    public boolean createSpaces() {
        Station lundby  = new Station(this, "Lundby", 7, 14);
        Station ramberget  = new Station(this, "Ramberget", 30, 26);
        Station chLindholmen  = new Station(this, "Chalmers Lindholmen", 30, 40);
        Station masthuggskykan  = new Station(this, "Masthuggskykan", 31, 57);
        Station lindholmen  = new Station(this, "Lindholmen", 34, 41);
        Station slottsberget  = new Station(this, "Slottsberget", 23, 45);
        Station slottskogen  = new Station(this, "Slottskogen", 37, 75);
        Station slottskogsvallen  = new Station(this, "Slottskogsvallen", 33, 90);
        Station eriksberg  = new Station(this, "Eriksberg", 10, 49);
        Station hjbrantings= new Station(this, "Hjalmar Brantingsplatsen", 47, 15);
        Station frihamnen= new Station(this, "Frihamnen", 53, 15);
        Station ringon= new Station(this, "Ringön", 66, 11);
        Station operan= new Station(this, "Operan",55 ,32 );
        Station nordstan= new Station(this, "Nordstan", 61, 36);
        Station stenpiren= new Station(this, "Stenpiren",50 ,41 );
        Station central= new Station(this, "Centralstationen", 68, 34);
        Station domkyrkan= new Station(this, "Domkyrkan", 58, 43);
        Station jarntorget= new Station(this, "Järntorget", 45, 51);
        Station ullevi= new Station(this, "Ullevi (någon av dem)",78 , 41);
        Station chalmers= new Station(this, "Chalmers", 69, 71);
        Station liseberg= new Station(this, "Liseberg", 83, 59);
        Station olofshojd= new Station(this, "Olofshöjd", 85, 74 );
        Station redbergsplatsen= new Station(this, "Redbergsplatsen", 95, 22);
        Station emilsborg= new Station(this, "Emilsborg", 76, 82);
        Station guldheden= new Station(this, "Guldheden", 65, 84 );
        Station linne= new Station(this, "Linnéplatsen", 45, 68);
        Station botaniska= new Station(this, "Botaniska trädgården", 44, 81);
        Station sahlgrenska= new Station(this, "Sahlgrenska sjukhuset", 54, 82);
        Station ostindiegatan= new Station(this, "Ostindiegatan", 11, 73);
        Station klippan= new Station(this, "Klippan", 7, 64);
        Station vasaplatsen= new Station(this, "Vasaplatsen", 63, 56);

        //Bicycle paths.
        slottskogen.getController().addPath(this,linne);
        slottskogen.getController().addPath(this,botaniska);
        slottskogen.getController().addPath(this,masthuggskykan);
        slottskogen.getController().addPath(this,slottskogsvallen);

        chLindholmen.getController().addPath(this,lindholmen);
        chLindholmen.getController().addPath(this,slottsberget);

        operan.getController().addPath(this,stenpiren);
        operan.getController().addPath(this,nordstan);

        emilsborg.getController().addPath(this,guldheden);
        emilsborg.getController().addPath(this,olofshojd);

        vasaplatsen.getController().addPath(this,linne);
        vasaplatsen.getController().addPath(this,ullevi);

        hjbrantings.getController().addPath(this,frihamnen);

        ramberget.getController().addPath(this,chLindholmen);
        ramberget.getController().addPath(this,lundby);

        nordstan.getController().addPath(this,central);
        nordstan.getController().addPath(this,domkyrkan);
        nordstan.getController().addPath(this,stenpiren);

        klippan.getController().addPath(this,ostindiegatan);

        chalmers.getController().addPath(this,guldheden);
        chalmers.getController().addPath(this,emilsborg);
        chalmers.getController().addPath(this,sahlgrenska);
        guldheden.getController().addPath(this,sahlgrenska);
        botaniska.getController().addPath(this,sahlgrenska);
        botaniska.getController().addPath(this,slottskogsvallen);

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
        operan.getController().addBoatPath(this, eriksberg);

        //Tram paths.
        hjbrantings.getController().addTramPath(this,lundby);
        hjbrantings.getController().addTramPath(this,ramberget);
        frihamnen.getController().addTramPath(this,chLindholmen);
        eriksberg.getController().addTramPath(this,lundby);
        frihamnen.getController().addTramPath(this,nordstan);
        central.getController().addTramPath(this,ullevi);
        domkyrkan.getController().addTramPath(this,jarntorget);
        jarntorget.getController().addTramPath(this,masthuggskykan);
        eriksberg.getController().addTramPath(this,lundby);
        masthuggskykan.getController().addTramPath(this,ostindiegatan);
        jarntorget.getController().addTramPath(this,linne);
        linne.getController().addTramPath(this,botaniska);
        slottskogsvallen.getController().addTramPath(this,ostindiegatan);
        chalmers.getController().addTramPath(this,liseberg);
        liseberg.getController().addTramPath(this,ullevi);
        liseberg.getController().addTramPath(this,olofshojd);
        frihamnen.getController().addTramPath(this,ringon);
        central.getController().addTramPath(this,redbergsplatsen);
        liseberg.getController().addTramPath(this,redbergsplatsen);
        vasaplatsen.getController().addTramPath(this,domkyrkan);
        vasaplatsen.getController().addTramPath(this,chalmers);

        //Start space.
        redbergsplatsen.getController().setStart();
        lundby.getController().setStart();
return true;
    }

    public void addSpaces(Spaces space) {
        spaces.add(space);
    }

    public ArrayList<Spaces> getSpaces() {
        return spaces;
    }
}
