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
        Stations lundby  = new Stations("Lundby", 7, 14);
        Stations ramberget  = new Stations("Ramberget", 30, 26);
        Stations chLindholmen  = new Stations("Chalmers Lindholmen", 30, 40);
        Stations masthuggskykan  = new Stations("Masthuggskykan", 31, 57);
        Stations lindholmen  = new Stations("Lindholmen", 34, 41);
        Stations slottsberget  = new Stations("Slottsberget", 23, 45);
        Stations slottskogen  = new Stations("Slottskogen", 37, 75);
        Stations slottskogsvallen  = new Stations("Slottskogsvallen", 33, 90);
        Stations eriksberg  = new Stations("Eriksberg", 11, 50);
        Stations hjbrantings= new Stations("Hjalmar Brantingsplatsen", 47, 15);
        Stations frihamnen= new Stations("Frihamnen", 53, 16);


 /*
        Stations nordstan = new Stations("Nordstan", 55,30);
        Stations chalmers = new Stations("Chalmers", 59,70);
        Stations jarntorget = new Stations("Järntorget", 39,50);
        Stations olskroken = new Stations("Olskroken", 95,10);
        Stations somewhere = new Stations("Somewhere", 95,80);
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
    }

    public void addSpaces(Spaces space) {
        spaces.add(space);
    }

    public ArrayList<Spaces> getSpaces() {
        return spaces;
    }
}
