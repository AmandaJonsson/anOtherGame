package Controllers;

import Design.MapView;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

/**
 * Created by Allex on 2017-04-27.
 */
public class theLostController {
    @FXML
    private Pane mapPlace;

    @FXML
    public void addMap(MapView map){
        mapPlace.getChildren().add(map);
    }
}
