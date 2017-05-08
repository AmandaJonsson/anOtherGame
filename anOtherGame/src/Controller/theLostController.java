package Controller;

import Model.*;
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

    private Player[] playerList;
    private Spaces position;
    private Player player;


    public theLostController(){

    }


    public theLostController(TheLostKitten newGame) {

        this.playerList = newGame.getPlayers();

        for(int i = 0; i<playerList.length; i++){
            if(playerList[i].playerHasTurn() == true){
                this.player = playerList[i];
            }
        }

        this.position = player.getPosition();


    }

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

    @FXML
    private Button nextPlayerButton = new Button();

    @FXML private Label alternativeText;

    private DropShadow shadow = new DropShadow();






    @FXML
    public void addMap(MapView map){
        mapPlace.getChildren().add(map);
    }

    @FXML
    public void setMouseEffect(){
        diceButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                diceButton.setEffect(shadow);
            }
        });

        diceButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                diceButton.setEffect(null);
            }
        });

        turnMarkerButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                turnMarkerButton.setEffect(shadow);
            }
        });

        turnMarkerButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                turnMarkerButton.setEffect(null);
            }
        });

        payButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                payButton.setEffect(shadow);
            }
        });

        payButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                payButton.setEffect(null);
            }
        });

        bicycleButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                bicycleButton.setEffect(shadow);
            }
        });

        bicycleButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                bicycleButton.setEffect(null);
            }
        });

        boatButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                boatButton.setEffect(shadow);
            }
        });

        boatButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                boatButton.setEffect(null);
            }
        });
        tramButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                tramButton.setEffect(shadow);
            }
        });

        tramButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                tramButton.setEffect(null);
            }
        });

        nextPlayerButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                nextPlayerButton.setEffect(shadow);
            }
        });

        nextPlayerButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                nextPlayerButton.setEffect(null);
            }
        });

    }

    @FXML protected int handleDiceButton(ActionEvent event) throws IOException {

        Dice dice = new Dice();
        int diceRoll=dice.roll();

        if(diceRoll==1){
            diceRoll=1;
        }
        if(diceRoll==2){
            diceRoll= 2;
        }
        if(diceRoll==3){
            diceRoll = 3;
        }
        if(diceRoll==4){
            diceRoll = 4;
        }
        if(diceRoll==5){
            diceRoll = 5;
        }
        if(diceRoll==6){
            diceRoll = 6;
        }

        if(diceRoll==4 || diceRoll == 5 || diceRoll == 6){
            alternativeText.setText("Du slog en" + " " + diceRoll + " " + "du får vända markern");

        } else{
            alternativeText.setText("Tyvärr du slog en" + " " + diceRoll + " " + "du får inte vända markern");
            turnMarkerButton.setDisable(true);
            payButton.setDisable(true);
            diceButton.setDisable(true);
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);
        }

        return diceRoll;

    }

    @FXML protected void handleTurnMarkerButton(ActionEvent event) throws IOException{

        if (event.getSource()==turnMarkerButton){
            alternativeText.setText("Välj att antingen betala 1000 kr eller slå tärningen och \n " +
                    "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'");
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

    @FXML protected void handleBoatButton(ActionEvent event) throws IOException{
        System.out.println("Åk båt");

    }

    @FXML protected void handleTramButton(ActionEvent event) throws IOException{
        System.out.println("Åk spårvagn");

    }

    @FXML protected void handleNextPlayerButton(ActionEvent event) throws IOException{
        alternativeText.setText(" ");
        turnMarkerButton.setDisable(false);
        payButton.setDisable(false);
        diceButton.setDisable(false);
        bicycleButton.setDisable(false);
        boatButton.setDisable(false);
        tramButton.setDisable(false);

    }

}


