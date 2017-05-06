package Controller;

import Model.Dice;
import View.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.io.IOException;


/**
 * Created by Allex on 2017-04-27.
 */
public class theLostController {
    @FXML
    private Pane mapPlace;

    @FXML
    private Button diceButton = new Button();

    @FXML
    private Button payButton = new Button();

    @FXML private Label alternativeText;

    @FXML
    public void addMap(MapView map){
        mapPlace.getChildren().add(map);
    }

    @FXML protected void handleDiceButton(ActionEvent event) throws IOException {

       DropShadow shadow = new DropShadow();
        shadow.setOffsetY(3.0);
        shadow.setOffsetX(3.0);

        diceButton.setOnMouseExited(new EventHandler<MouseEvent>
                () {

            @Override
            public void handle(MouseEvent event) {
                diceButton.setEffect(shadow);
            }
        });

        diceButton.setOnMouseExited(new EventHandler<MouseEvent>
                () {
                    @Override
                    public void handle(MouseEvent event) {
                        diceButton.setEffect(null);

                    }
                });


        
        Dice dice = new Dice();
        int diceRoll=dice.roll();

        if (diceRoll == 4 || diceRoll == 5 || diceRoll == 6) {
            alternativeText.setText("Du slog en" + " " + diceRoll + " " + "du får vända markern");
            // turnMarker();
        } else{
            alternativeText.setText("Tyvärr du slog en" + " " + diceRoll + " " + "du får inte vända markern");
        }

    }

    @FXML protected void handleTurnMarkerButton(ActionEvent event) throws IOException{
        System.out.println("Turn Marker");

        alternativeText.setText("Välj att antingen betala 1000 kr eller slå tärningen och \n " +
                "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'");
        //Click the Dice Button


    }

    @FXML protected void handlePayButton(ActionEvent event) throws IOException{
        System.out.println("pay");


    }
}


