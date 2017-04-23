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
        Stations lundby  = new Stations(this, "Lundby", 7, 14);
        Stations ramberget  = new Stations(this, "Ramberget", 30, 26);
        Stations chLindholmen  = new Stations(this, "Chalmers Lindholmen", 30, 40);
        Stations masthuggskykan  = new Stations(this, "Masthuggskykan", 31, 57);
        Stations lindholmen  = new Stations(this, "Lindholmen", 34, 41);
        Stations slottsberget  = new Stations(this, "Slottsberget", 23, 45);
        Stations slottskogen  = new Stations(this, "Slottskogen", 37, 75);
        Stations slottskogsvallen  = new Stations(this, "Slottskogsvallen", 33, 90);
        Stations eriksberg  = new Stations(this, "Eriksberg", 10, 49);
        Stations hjbrantings= new Stations(this, "Hjalmar Brantingsplatsen", 47, 15);
        Stations frihamnen= new Stations(this, "Frihamnen", 53, 15);
        Stations ringon= new Stations(this, "Ringön", 66, 11);
        Stations operan= new Stations(this, "Operan",55 ,32 );
        Stations nordstan= new Stations(this, "Nordstan", 61, 36);
        Stations stenpiren= new Stations(this, "Stenpiren",50 ,41 );
        Stations central= new Stations(this, "Centralstationen", 68, 34);
        Stations domkyrkan= new Stations(this, "Domkyrkan", 58, 43);
        Stations jarntorget= new Stations(this, "Järntorget", 45, 51);
        Stations ullevi= new Stations(this, "Ullevi (någon av dem)",78 , 41);
        Stations chalmers= new Stations(this, "Chalmers", 69, 71);
        Stations liseberg= new Stations(this, "Liseberg", 83, 59);
        Stations olofshojd= new Stations(this, "Olofshöjd", 85, 74 );
        Stations redbergsplatsen= new Stations(this, "Redbergsplatsen", 95, 22);
        Stations emilsborg= new Stations(this, "Emilsborg", 76, 82);
        Stations guldheden= new Stations(this, "Guldheden", 65, 84 );
        Stations linne= new Stations(this, "Linnéplatsen", 45, 68);
        Stations botaniska= new Stations(this, "Botaniska trädgården", 44, 81);
        Stations sahlgrenska= new Stations(this, "Sahlgrenska sjukhuset", 54, 82);
        Stations ostindiegatan= new Stations(this, "Ostindiegatan", 11, 73);
        Stations klippan= new Stations(this, "Klippan", 7, 64);

        /*
        Stations nordstan = new Stations(this, "Nordstan", 55,30);
        Stations chalmers = new Stations(this, "Chalmers", 59,70);
        Stations jarntorget = new Stations(this, "Järntorget", 39,50);
        Stations olskroken = new Stations(this, "Olskroken", 95,10);
        Stations somewhere = new Stations(this, "Somewhere", 95,80);
        chalmers.addPath(this, olskroken);
        olskroken.addPath(this, somewhere);
        nordstan.addPath(this, jarntorget);
        nordstan.addPath(this, chalmers);
        spaces.add(nordstan);
        spaces.add(chalmers);
        spaces.add(jarntorget);
        spaces.add(olskroken);
        spaces.add(somewhere);
*/
/*
        spaces.add(lundby);
        spaces.add(ramberget);
        spaces.add(chLindholmen);
        spaces.add(masthuggskykan);
        spaces.add(lindholmen);
        spaces.add(slottsberget);
        spaces.add(slottskogen);
        spaces.add(slottskogsvallen);
        spaces.add(eriksberg);
        spaces.add(hjbrantings);
        spaces.add(frihamnen);
        return true;
        */

chalmers.addPath(this,redbergsplatsen);
return true;
    }

    public void addSpaces(Spaces space) {
        spaces.add(space);
    }

    public ArrayList<Spaces> getSpaces() {
        return spaces;
    }
}
