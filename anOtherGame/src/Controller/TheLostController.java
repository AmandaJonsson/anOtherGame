
/**
 * @author Amanda
 * Revised by: *name*
 * Responsibility: Handles the actions on the view and update labels etc.
 * Used by:
 * Uses: IDice, ITheLostKitten,
 */


package Controller;


import Model.Intefaces.IDice;
import Model.Intefaces.IMarker;
import Model.Intefaces.IPlayer;
import Model.Intefaces.ITheLostKitten;
import Model.OtherMarkers;
import Model.Player;
import Model.Station;
import View.MapView;
import event.Event;
import event.EventBus;
import event.IEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TheLostController implements IEventHandler{
    
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
    @FXML
    private Label alternativeText;
    @FXML
    public Label playersTurnLabel = new Label();

    Image cat = new Image("Resources/cat.png");



    private String turnMakerText = "Välj att antingen betala 1000 kr eller slå tärningen och \n " +
            "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'";

    private DropShadow shadow = new DropShadow();
    static IDice dice;
    static ITheLostKitten lostKitten;
    static List<IPlayer> newCreatedPlayers;
    ArrayList<PlayerPaneController> listOfPlayerPanes;
    private MapView mapView;

    public TheLostController(){


    }

    public TheLostController(ITheLostKitten newGame, IDice lostdice, ArrayList<PlayerPaneController> listOfPlayerpanes) {
        lostKitten = newGame;
        dice=lostdice;
        newCreatedPlayers = newGame.getPlayers();
        listOfPlayerPanes=listOfPlayerpanes;
        initEvent();
    }


    @FXML
    public void addMap(MapView map){

        this.mapView=map;
        ArrayList<IPlayer> players = new ArrayList<>();
        players.addAll(lostKitten.getListOfPlayers());
        //mapView.setPlayerPosition(players);
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

    @FXML protected void handleTurnMarkerButton(ActionEvent event) throws IOException {

        IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();
        if (lostKitten.checkIfMarkerIsTurned(mark)==true ){
            alternativeText.setText("Det finns ingen marker på denna stationen");
            payButton.setDisable(true);
            diceButton.setDisable(true);
        } else {
            alternativeText.setText(turnMakerText);
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);
            turnMarkerButton.setDisable(true);
            mark.setMarkerToTurned();

        }


    }

    @FXML protected void handlePayButton(ActionEvent event) throws IOException{
        diceButton.setDisable(true);
        payButton.setDisable(true);
        if(alternativeText.getText() == turnMakerText){
            lostKitten.setNewDecreasedBudget(1000);
            alternativeText.setText("Du har köpt markern");
        }

        if(alternativeText.getText() =="Du har köpt markern" ) {
            lostKitten.setNewBudget();
        }
        IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();

        if (mark instanceof OtherMarkers) {
            if ((((OtherMarkers) mark).getMarkerType() == OtherMarkers.NoMoneyMarkers.CAT)) {
                lostKitten.getActivePlayer().setHasCat();

            }

            if ((((OtherMarkers) mark).getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD)) {
                lostKitten.getActivePlayer().gotTramCard();

            }
        }
    }


    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        int numberOnDice = lostKitten.getDice().roll();
        System.out.println(numberOnDice);
        System.out.println(lostKitten.moveByBike());

        /*
        int diceRoll = dice.roll();
        //lostKitten.moveByBike(diceRoll);
        System.out.println("Tärningen visar: " + diceRoll);
        System.out.println(lostKitten.getActivePlayer().getName());
        System.out.println(lostKitten.getActivePlayer().getPosition());
*/
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
        int diceroll = dice.roll();
        lostKitten.moveByBoat(diceroll);
        System.out.println("Åk båt");

    }

    @FXML protected void handleTramButton(ActionEvent event) throws IOException{
        int diceroll = dice.roll();
        lostKitten.moveByTram(diceroll);
        System.out.println("Åk spårvagn");
    }

    @FXML protected void handleNextPlayerButton(ActionEvent event) throws IOException{

        updatePlayerTurn();
        setPlayersTurnLabel(lostKitten.getActivePlayer().getName());
        alternativeText.setText(" ");
        turnMarkerButton.setDisable(false);
        payButton.setDisable(false);
        diceButton.setDisable(false);
        bicycleButton.setDisable(false);
        boatButton.setDisable(false);
        tramButton.setDisable(false);

        IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();
        if(lostKitten.checkIfMarkerIsTurned(mark)){
            turnMarkerButton.setDisable(true);
        }
    }

    public void setPlayersTurnLabel(String text){
        System.out.println(text);
        playersTurnLabel.setText("Din tur" + " " + text);
    }

    public void updatePlayerTurn(){
        lostKitten.getNextPlayer();
    }

    @Override
    public void onEvent(Event evt) {
        if (evt.getTag() == Event.Tag.PLAYER_BALANCE) {
            for (int i = 0; i < listOfPlayerPanes.size(); i++) {
                if (listOfPlayerPanes.get(i).nameLabel.getText() == lostKitten.getActivePlayer().getName()) {
                    listOfPlayerPanes.get(i).budgetLabel.setText("Pengar:" + lostKitten.getActivePlayer().getBalance() + " kr");
                    System.out.println("EHJEEJHE");

                }
            }
        }
    }

    private void initEvent() {
        EventBus.BUS.register(this);
    }

}




