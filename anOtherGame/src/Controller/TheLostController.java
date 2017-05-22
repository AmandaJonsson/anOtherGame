/*Authors: Amanda
Responsibility: Handles the actions on the view and update labels etc.
Used by:
Uses: IDice, ITheLostKitten,
 */

package Controller;

import Model.*;
import Model.Intefaces.IDice;
import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.Intefaces.ITheLostKitten;
import View.MapView;
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


public class TheLostController {
    
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

    private String turnMakerText = "Välj att antingen betala 1000 kr eller slå tärningen och \n " +
            "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'";

    private DropShadow shadow = new DropShadow();

    static IDice dice;

    static ITheLostKitten lostKitten;

    static List<IPlayer> newCreatedPlayers;

    static ArrayList<PlayerPaneController> listOfPlayerPanes;

    public TheLostController(){

    }

    public TheLostController(ITheLostKitten newGame, IDice lostdice, ArrayList<PlayerPaneController> listOfPlayerpanes) {
        lostKitten = newGame;
        dice=lostdice;
        newCreatedPlayers = newGame.getPlayers();
        listOfPlayerPanes=listOfPlayerpanes;

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
            //lostKitten.setBudgetLabel();
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
            alternativeText.setText(turnMakerText);
            bicycleButton.setDisable(true);
            boatButton.setDisable(true);
            tramButton.setDisable(true);
            turnMarkerButton.setDisable(true);

        }

    }

    @FXML protected void handlePayButton(ActionEvent event) throws IOException{
        diceButton.setDisable(true);
        payButton.setDisable(true);
        if(alternativeText.getText() == turnMakerText){
            lostKitten.setNewDecreasedBudget(1000);
            setBudgetLabel();
            alternativeText.setText("Du har köpt markern");
        }


        if(alternativeText.getText() =="Du har köpt markern" ) {
            lostKitten.setNewBudget();
            setBudgetLabel();
        }
    }

    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        int diceRoll = dice.roll();
        //lostKitten.moveByBike(diceRoll);
        System.out.println("Tärningen visar: " + diceRoll);
        System.out.println(lostKitten.getActivePlayer().getName());
        System.out.println(lostKitten.getActivePlayer().getPosition());
        System.out.println(FindPath.findPotentialSpaces(diceRoll,lostKitten.getActivePlayer().getPosition()));

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



    public void setBudgetLabel(){
        for(int i =0; i<listOfPlayerPanes.size(); i++){
            if(listOfPlayerPanes.get(i).nameLabel.getText() == lostKitten.getActivePlayer().getName()){
                listOfPlayerPanes.get(i).budgetLabel.setText("Pengar:" + lostKitten.getActivePlayer().getBalance() + " kr");
            }
        }

    }
}



