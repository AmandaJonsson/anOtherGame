/**
 * @author Amanda, Maja
 * Revised by: Everybody
 * Responsibility: Handles the actions on the view and update labels etc.
 * Used by:
 * Uses: IDice, ITheLostKitten,
 */
package Controller;
import Model.Interfaces.*;
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
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.*;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class TheLostKittenController implements IEventHandler {

    @FXML private Button diceButton = new Button();
    @FXML private Button turnMarkerButton = new Button();
    @FXML private Button bicycleButton = new Button();
    @FXML private Button tramButton = new Button();
    @FXML private Button payButton = new Button();
    @FXML private Button nextPlayerButton = new Button();
    @FXML private Label alternativeText;
    @FXML public Label playersTurnLabel = new Label();
    @FXML private Label playerWonLabel= new Label();
    @FXML private Button playAgainButton = new Button();
    @FXML private Stage gameOverStage = new Stage();

    private String turnMakerText = "Välj att antingen betala 1000 kr eller slå\ntärningen och" +
            " få 4,5 eller 6 för att vända\nmarkern.Tryck på 'Betala' eller 'Slå tärning'";

    private DropShadow shadow = new DropShadow();
    static IDice dice;
    static ITheLostKitten lostKitten;
    static List<IPlayer> newCreatedPlayers;
    ArrayList<PlayerPaneController> listOfPlayerPanes;
    static MapView mapView;

    public TheLostKittenController() throws IOException {

    }

    public TheLostKittenController(ITheLostKitten newGame, IDice lostdice, ArrayList<PlayerPaneController> listOfPlayerpanes, MapView mapView) throws IOException {
        lostKitten = newGame;
        dice = lostdice;
        newCreatedPlayers = newGame.getPlayers();
        listOfPlayerPanes = listOfPlayerpanes;
        this.mapView = mapView;
        initEvent();
    }


    public void setPayButtonDisable(){
        payButton.setDisable(true);
    }
    public void setDiceButtonDisable(){
        diceButton.setDisable(true);
    }
    public void setTurnMarkerButtonDisable(){
        turnMarkerButton.setDisable(true);
    }


    @FXML
    public void setMouseEffect() {

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

    @FXML
    protected void handleDiceButton(ActionEvent event) throws IOException {

        int diceRoll = dice.roll();

        if (diceRoll == 4 || diceRoll == 5 || diceRoll == 6) {
            alternativeText.setText("Du slog en" + " " + diceRoll + " " + "du fick markern");
            lostKitten.setNewBudget();
            payButton.setDisable(true);
            diceButton.setDisable(true);

        } else {
            alternativeText.setText("Tyvärr du slog en" + " " + diceRoll + " " + "du får inte vända markern");
            turnMarkerButton.setDisable(true);
            payButton.setDisable(true);
            diceButton.setDisable(true);
            bicycleButton.setDisable(true);
            tramButton.setDisable(true);
        }
    }

    @FXML
    protected void handleTurnMarkerButton(ActionEvent event) throws IOException {

        if (!(lostKitten.getActivePlayer().getPosition() instanceof Station)) {
            alternativeText.setText("Detta är ingen station och här\nfinns ingen marker.");
            turnMarkerButton.setDisable(true);
            payButton.setDisable(true);
            diceButton.setDisable(true);
        }

        else if (lostKitten.getActivePlayer().getPosition() instanceof Station) {
                Station station = (Station) lostKitten.getActivePlayer().getPosition();
                if (station.hasMarker()) {
                    IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();
                        if (lostKitten.checkIfMarkerIsTurned(mark)) {
                            alternativeText.setText("Det finns ingen marker på denna stationen");
                            payButton.setDisable(true);
                            diceButton.setDisable(true);
                        } else {
                            payButton.setDisable(false);
                            diceButton.setDisable(false);
                            alternativeText.setText(turnMakerText);
                            bicycleButton.setDisable(true);
                            tramButton.setDisable(true);
                            turnMarkerButton.setDisable(true);
                            mark.setMarkerToTurned();

                        }
                }

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

        if(lostKitten.getActivePlayer().getPosition() instanceof Station){
            IMarker mark = ((Station) lostKitten.getActivePlayer().getPosition()).getMarker();


            if (mark instanceof OtherMarkers) {
                if ((((OtherMarkers) mark).getMarkerType() == OtherMarkers.NoMoneyMarkers.CAT)) {
                    if(!lostKitten.getSomeoneFoundCat()){
                        lostKitten.getActivePlayer().setHasCat();
                        lostKitten.setSomeoneFoundCat();
                    }
                }

                if ((((OtherMarkers) mark).getMarkerType() == OtherMarkers.NoMoneyMarkers.TRAMCARD)) {

                    if(!lostKitten.getSomeoneFoundTramCard()){
                        lostKitten.getActivePlayer().gotTramCard();
                        lostKitten.setSomeoneFoundTramCard();
                    }

                }

                if ((((OtherMarkers) mark).getMarkerType() == OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
                    if(!lostKitten.getSomeoneGotRobbed()){
                        lostKitten.getActivePlayer().robbedByPickpocket();
                        lostKitten.setSomeoneGotRobbed();
                    }

                }
            }

        }


    }


    @FXML protected void handleBicycleButton(ActionEvent event) throws IOException{
        alternativeText.setText("Välj vilken väg du vill åka genom att\ntrycka på den positionen.");
        bicycleButton.setDisable(true);
        tramButton.setDisable(true);
        turnMarkerButton.setDisable(false);
        lostKitten.moveByBike();
    }

    @FXML protected void handleTramButton(ActionEvent event) throws IOException{
        lostKitten.moveByTram();
    }

    @FXML public void handlePlayerAgainButton(ActionEvent event) throws IOException {

        Window window = mapView.getScene().getWindow();
        if (window instanceof Stage){
            ((Stage) window).close();
        }

        Window window2 = playAgainButton.getScene().getWindow();
        if (window2 instanceof Stage){
            ((Stage) window2).close();
        }

        Stage newStage = new Stage();
        newStage.setTitle("The Lost Kitten");
        FXMLLoader loader = new FXMLLoader();
        newStage.setScene(new Scene(loader.load(getClass().getResource("/start.fxml"))));
        newStage.show();
        newStage.setResizable(false);



    }

    @FXML public void handleFinishGameButton(ActionEvent event){
        System.exit(0);
    }

    @FXML protected void handleNextPlayerButton(ActionEvent event) throws IOException{
        if(checkGameOver()) {
            FXMLLoader loader = new FXMLLoader();

            Pane gameOverPane = (Pane) loader.load(getClass().getResource("/gameOverPane.fxml"));
            playerWonLabel = (Label)gameOverPane.lookup("#playerWonLabel");
            playerWonLabel.setText("Spelare " + lostKitten.getActivePlayer().getName() + " vann!");
            Scene gameOverScene = new Scene(gameOverPane);
            gameOverStage.setScene(gameOverScene);
            gameOverStage.show();


        }else {
            updatePlayerTurn();
            setPlayersTurnLabel(lostKitten.getActivePlayer().getName());
            alternativeText.setText(" ");
            turnMarkerButton.setDisable(false);
            payButton.setDisable(true);
            diceButton.setDisable(true);
            bicycleButton.setDisable(false);
            if (checkIfAbleToGoByTram() && !checkIfEnoughMoneyForTram()) {
                tramButton.setDisable(false);
            }
        }
    }


    public boolean checkIfAbleToGoByTram(){
        if(lostKitten.getActivePlayer().getPosition() instanceof IStation){
            for(ISpace space :lostKitten.getActivePlayer().getPosition().getAdjacentSpaces()){
                if(space instanceof IStation){
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    public boolean checkIfEnoughMoneyForTram(){
        if(lostKitten.getActivePlayer().getBalance() < 3000){
            return true;
        }
        return false;
    }


    public void setPlayersTurnLabel(String text){
        playersTurnLabel.setText("Din tur" + " " + text);
    }

    public void updatePlayerTurn(){
        lostKitten.getNextPlayer();
    }

    private boolean checkGameOver(){
        if((lostKitten.getActivePlayer().getPosition() == lostKitten.getMap().getStartPositions().get(0))
                ||(lostKitten.getActivePlayer().getPosition() == lostKitten.getMap().getStartPositions().get(1))) {
            if (lostKitten.getSomeoneFoundCat()) {
                if (lostKitten.getActivePlayer().hasTramCard() || lostKitten.getActivePlayer().hasCat()) {
                    return true;
                }
            }
        }
        return false;
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

        else if(evt.getTag() == Event.Tag.PLAYER_CAT){
            lostKitten.setSomeoneFoundCat();
        }
        else if(evt.getTag() == Event.Tag.PLAYER_TRAMCARD){
            lostKitten.setSomeoneFoundTramCard();
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

                        mapView.getListOfSpaceViews().get(i).setColor(getColorOfPlayer(lostKitten.getListOfPlayers().get(j)));
                    }else{
                        if(!(mapView.getListOfSpaceViews().get(i).getColor().equals("#d8bfd8")
                                || mapView.getListOfSpaceViews().get(i).getColor().equals("#fff5ee")
                                || mapView.getListOfSpaceViews().get(i).getColor().equals("#7fffd4")
                                || mapView.getListOfSpaceViews().get(i).getColor().equals("#5f9ea0")
                                || mapView.getListOfSpaceViews().get(i).getColor().equals("#9acd32")
                                || mapView.getListOfSpaceViews().get(i).getColor().equals("#c0c0c0"))){
                            //Här! Förut kollade den om den var blå, nu måste den kolla den om de 6 andra färgerna!

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

    public String getColorOfPlayer(IPlayer player){
        for(int i = 0; i< listOfPlayerPanes.size(); i++){
            if(listOfPlayerPanes.get(i).getPlayer().getName().equals(player.getName())){
                if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: thistle;")){
                    return "#d8bfd8";
                }else if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: seashell;")){
                    return "#fff5ee";
                }else if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: aquamarine;")){
                    return "#7fffd4";
                }else if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: cadetblue;")){
                    return "#5f9ea0";
                }else if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: yellowgreen;")){
                    return "#9acd32";
                }else if(listOfPlayerPanes.get(i).getView().getStyle().equals(" -fx-background-color: silver;")){
                    return "#c0c0c0";
                }
            }
        }
        return "Blue";
    }

    private void initEvent() {
        EventBus.BUS.register(this);
    }




}




