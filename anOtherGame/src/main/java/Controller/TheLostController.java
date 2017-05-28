/**
 * @author Amanda
 * Revised by: *name*
 * Responsibility: Handles the actions on the view and update labels etc.
 * Used by:
 * Uses: IDice, ITheLostKitten,
 */
package Controller;
import Model.Intefaces.*;
import Model.OtherMarkers;
import Model.Station;
import View.MapView;
import View.SpaceView;
import event.Event;
import event.EventBus;
import event.IEventHandler;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.*;


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

    private boolean gameOver = false;

    Image cat = new Image("cat.png");



    private String turnMakerText = "Välj att antingen betala 1000 kr eller slå tärningen och \n " +
            "få 4,5 eller 6 för att vända markern.\n Tryck på 'Betala' eller 'Slå tärning'";

    private DropShadow shadow = new DropShadow();
    static IDice dice;
    static ITheLostKitten lostKitten;
    static List<IPlayer> newCreatedPlayers;
    ArrayList<PlayerPaneController> listOfPlayerPanes;
    static MapView mapView;
    IPlayer winningPlayer;

    MapController mapController = new MapController(mapView);;
    public TheLostController(){

    }

    public TheLostController(ITheLostKitten newGame, IDice lostdice, ArrayList<PlayerPaneController> listOfPlayerpanes, MapView mapView) {
        lostKitten = newGame;
        dice=lostdice;
        newCreatedPlayers = newGame.getPlayers();
        listOfPlayerPanes=listOfPlayerpanes;
        this.mapView = mapView;
        initEvent();
    }



    @FXML
    public void addMap(MapView map) {

        this.mapView = map;
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


        if(lostKitten.getActivePlayer().getPosition() instanceof Station){

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


        System.out.println(lostKitten.getActivePlayer().getPosition());

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

        if(lostKitten.getActivePlayer().getPosition() instanceof Station){
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


    }


    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        lostKitten.moveByBike();

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
        if(checkIfAbleToGoByTram()){
            tramButton.setDisable(false);
        }
        disableTurnMarkerButton();

    }

    public void disableTurnMarkerButton(){
        if(lostKitten.getActivePlayer().getPosition() instanceof Station){
            Station station = (Station) lostKitten.getActivePlayer().getPosition();
            if(station.hasMarker()) {
                IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();
                if(lostKitten.checkIfMarkerIsTurned(mark)){
                    turnMarkerButton.setDisable(true);
                }

            }

        }
    }

    public boolean checkIfAbleToGoByTram(){
        if(lostKitten.getActivePlayer().getPosition() instanceof Station){
            for(ISpace space :lostKitten.getActivePlayer().getPosition().getAdjacentSpaces()){
                if(space instanceof Station){
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    public void setPlayersTurnLabel(String text){
        playersTurnLabel.setText("Din tur" + " " + text);
    }

    public void updatePlayerTurn(){
        lostKitten.getNextPlayer();
    }

    public boolean getGameOver(){
        return this.gameOver;
    }


    public void setBudgetLabel(){}

    public IPlayer getWinningPlayer(){
        return winningPlayer;
    }

    @Override
    public void onEvent(Event evt) {
        if (evt.getTag() == Event.Tag.PLAYER_BALANCE) {
            for (int i = 0; i < listOfPlayerPanes.size(); i++) {
                if (listOfPlayerPanes.get(i).nameLabel.getText() == lostKitten.getActivePlayer().getName()) {
                    listOfPlayerPanes.get(i).budgetLabel.setText("Pengar: " + lostKitten.getActivePlayer().getBalance() + " kr");
                }
            }
        }

        else if(evt.getTag() == Event.Tag.PLAYER_POSITION){
            if((lostKitten.getActivePlayer().getPosition() == lostKitten.getMap().getStartPositions().get(0))
                    ||(lostKitten.getActivePlayer().getPosition() == lostKitten.getMap().getStartPositions().get(1))){
                if(lostKitten.getSomeoneFoundCat() == true){
                    if(lostKitten.getActivePlayer().gotTramCard() == true){
                        System.out.println("spelare som hade västtrafikskort vann");
                        gameOver = true;
                        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_WON, this));
                    }
                    if(lostKitten.getActivePlayer().hasCat() == true){
                        System.out.println("spelare som hade katt vann");
                        gameOver = true;
                        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_WON, this));
                    }
                }
            }
        }

        else if(evt.getTag() == Event.Tag.PLAYER_CAT){
            lostKitten.setSomeoneFoundCat();
        }

        else if(evt.getTag()==Event.Tag.SPACE_CHOSEN) {
            SpaceView sw = (SpaceView) evt.getValue();

            //the active player's position is updated with the spaces of the onclicked spaceview.
            for (int i = 0; i < lostKitten.getMap().getSpaces().size(); i++) {
                if (lostKitten.getMap().getSpaces().get(i).compareSpaces(sw.getLocationOfSpace())) {
                    lostKitten.getActivePlayer().setPosition(lostKitten.getMap().getSpaces().get(i));
                }
            }

            //the player's positions are marked with bluuuuuue
            //the rest should be deafultcolor/picture
            for(int i = 0; i < mapView.getListOfSpaceViews().size(); i++){
                mapView.getListOfSpaceViews().get(i).setColor(mapView.getListOfSpaceViews().get(i).getDefaultColor());
                for(int j = 0; j < lostKitten.getListOfPlayers().size(); j++){

                    if(lostKitten.getListOfPlayers().get(j).getPosition().compareSpaces(mapView.getListOfSpaceViews().get(i).getLocationOfSpace())){
                        mapView.getListOfSpaceViews().get(i).setColor("Blue");
                    }else{
                        if(!mapView.getListOfSpaceViews().get(i).getColor().equals("Blue")){

                            if(mapView.getListOfSpaceViews().get(i).getX() == 95 && mapView.getListOfSpaceViews().get(i).getY() == 22){
                                Image img = new Image("/redbergsplatsen-01.png");
                                mapView.getListOfSpaceViews().get(i).setFill(new ImagePattern(img));
                            }else if(mapView.getListOfSpaceViews().get(i).getX() == 7 && mapView.getListOfSpaceViews().get(i).getY() == 14){
                                Image img = new Image("/lundby-01.png");
                                mapView.getListOfSpaceViews().get(i).setFill(new ImagePattern(img));
                            }else{
                                mapView.getListOfSpaceViews().get(i).setColor(mapView.getListOfSpaceViews().get(i).getDefaultColor());
                            }
                        }
                    }
                }
            }

            //when player chosen its new position the potential spaces should no longer be marked.
            for(int i = 0; i < mapView.getListOfSpaceViews().size(); i++) {
                mapView.getListOfSpaceViews().get(i).setStrokeWidth(0);
                mapView.getListOfSpaceViews().get(i).setDefaultColor(mapView.getListOfSpaceViews().get(i).getDefaultColor());
            }
        }
    }

    private void initEvent() {
        EventBus.BUS.register(this);
    }

}




