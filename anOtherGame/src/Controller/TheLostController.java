package Controller;

import Model.*;
import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import View.MapView;
import View.SpaceView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.Player;
import Model.TheLostKitten;


/**
 * Created by Allex on 2017-04-27.
 */
public class TheLostController {

    private Player[] playerList;
    private Space position;
    private MainController con;

    FindPath findPath;
    Player player;

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

    @FXML public Label playersTurnLabel = new Label();

    private String turnMakerButton = "Välj att antingen betala 1000 kr eller slå tärningen och \n " +
            "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'";

    private DropShadow shadow = new DropShadow();

    static Dice dice;

    static TheLostKitten lostKitten;

    static List<IPlayer> newCreatedPlayers;

    public TheLostController() {

    }

    public TheLostController(TheLostKitten newGame, Dice lostdice) {
        lostKitten = newGame;
        dice=lostdice;
        System.out.println(dice);
        //dice=newGame.getDice();
        newCreatedPlayers = newGame.getPlayers();
    }


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

    @FXML protected void handleDiceButton(ActionEvent event) throws IOException {

        int diceRoll = dice.roll();
        System.out.println(diceRoll);

        if (diceRoll == 1) {
            diceRoll = 1;
        }
        if (diceRoll == 2) {
            diceRoll = 2;
        }
        if (diceRoll == 3) {
            diceRoll = 3;
        }
        if (diceRoll == 4) {
            diceRoll = 4;
        }
        if (diceRoll == 5) {
            diceRoll = 5;
        }
        if (diceRoll == 6) {
            diceRoll = 6;
        }


        if (diceRoll == 4 || diceRoll == 5 || diceRoll == 6) {
            alternativeText.setText("Du slog en" + " " + diceRoll + " " + "du får vända markern");
            lostKitten.setNewBudget();
            payButton.setDisable(true);
            diceButton.setDisable(true);

        } else {
            alternativeText.setText("Tyvärr du slog en" + " " + diceRoll + " " + "du får inte vända markern");
            turnMarkerButton.setDisable(true);
            payButton.setDisable(true);
            diceButton.setDisable(true);
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);
        }
    }

    @FXML protected void handleTurnMarkerButton(ActionEvent event) throws IOException{

        if (event.getSource()==turnMarkerButton){
            alternativeText.setText(turnMakerButton);
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);
            turnMarkerButton.setDisable(true);

        }



    }

    @FXML protected void handlePayButton(ActionEvent event) throws IOException{
        System.out.println("pay");

    }

    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        int diceroll = lostKitten.getDice().roll();
//        findPath.findPotentialSpaces(diceroll, player.getPosition());
        alternativeText.setText("Välj vilken väg du vill åka genom att trycka på den positionen");
        bicycleButton.setDisable(true);
        boatButton.setDisable(true);
        tramButton.setDisable(true);
        turnMarkerButton.setDisable(true);
        payButton.setDisable(true);
        diceButton.setDisable(true);
        System.out.println("Cykla");

    }

    @FXML protected void handleBoatButton(ActionEvent event) throws IOException{
        System.out.println("Åk båt");

    }

    @FXML protected void handleTramButton(ActionEvent event) throws IOException{
        System.out.println("Åk spårvagn");

    }

    @FXML protected void handleNextPlayerButton(ActionEvent event) throws IOException{

        String turn=updatePlayerTurn();
        setPlayersTurnLabel(turn);
        alternativeText.setText(" ");
        turnMarkerButton.setDisable(false);
        payButton.setDisable(false);
        diceButton.setDisable(false);
        bicycleButton.setDisable(false);
        boatButton.setDisable(false);
        tramButton.setDisable(false);

    }

    public void setPlayersTurnLabel(String text){
        System.out.println(text);
        playersTurnLabel.setText("Din tur" + " " + text);
    }

    public String updatePlayerTurn(){

        for(int i=0; i<newCreatedPlayers.size();i++){
            if(newCreatedPlayers.get(i).playerHasTurn()){
                newCreatedPlayers.get(i).setNotTurn();
                newCreatedPlayers.get((i + 1) % newCreatedPlayers.size()).setTurn();
                IPlayer nextplayer = newCreatedPlayers.get((i + 1) % newCreatedPlayers.size());
                String turn = newCreatedPlayers.get((i+1)%newCreatedPlayers.size()).getName();
                lostKitten.setActivePlayer(nextplayer);
                return turn;
            }
        }
        return null;
    }


}



