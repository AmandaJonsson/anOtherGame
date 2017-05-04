package Controller;

import Model.Dice;
import Model.Station;
import View.MapView;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;


/**
 * Created by Allex on 2017-04-27.
 */
public class theLostController {
    @FXML
    private Pane mapPlace;

    @FXML
    private Button diceButton = new Button();
    DropShadow shadow = new DropShadow();


    @FXML
    public void addMap(MapView map){
        mapPlace.getChildren().add(map);
    }

    @FXML protected void handleDiceButton(ActionEvent event) throws IOException {

        diceButton.addEventHandler(MouseEvent.MOUSE_ENTERED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        diceButton.setEffect(shadow);

                    }
                });

        diceButton.addEventHandler(MouseEvent.MOUSE_EXITED,
                new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent e) {
                        diceButton.setEffect(null);
                    }
                });
        
        Dice dice = new Dice();
        dice.roll();

    }

}


