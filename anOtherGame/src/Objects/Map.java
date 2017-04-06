package Objects;


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
        addSpaces();
    }

    private void addSpaces() {
        Stations nordstan = new Stations("Nordstan", 55,30);
        Stations chalmers = new Stations("Chalmers", 59,70);
        Stations jarntorget = new Stations("Järntorget", 39,50);
        Stations olskroken = new Stations("Olskroken", 95,10);
        nordstan.addAdjacentSpace(chalmers);
        nordstan.addAdjacentSpace(jarntorget);
        chalmers.addAdjacentSpace(olskroken);
        //group = new Group();
        spaces.add(nordstan);
        spaces.add(chalmers);
        spaces.add(jarntorget);
        spaces.add(olskroken);
        //group.getChildren().add();
        //this.getChildren().add(group);
    }


    public ArrayList<Spaces> getSpaces() {
        return spaces;
    }
}
