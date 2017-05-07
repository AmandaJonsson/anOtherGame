package Controller;

import Model.Dice;
import View.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.*;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

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
    private Button turnMarkerButton = new Button();

    @FXML
    private Button bicycleButton = new Button();

    @FXML
    private Button boatButton = new Button();

    @FXML
    private Button tramButton = new Button();

    @FXML
    private Button payButton = new Button();

    @FXML private Label alternativeText;

    private DropShadow shadow = new DropShadow();


    @FXML
    public void addMap(MapView map){
        mapPlace.getChildren().add(map);
    }

    @FXML protected void handleDiceButton(ActionEvent event) throws IOException {

            diceButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
                    System.out.println("button");
                }
            });

            diceButton.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent e) {
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

        alternativeText.setText("Välj att antingen betala 1000 kr eller slå tärningen och \n " +
                "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'");

        if (event.getSource()==turnMarkerButton){
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);

        }
    }

    @FXML protected void handlePayButton(ActionEvent event) throws IOException{
        System.out.println("pay");


    }

    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        System.out.println("Cykla");


    }


}


