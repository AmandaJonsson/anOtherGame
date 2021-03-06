/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Handles the start view.
 * Used by: TheLostKittenController
 * Uses: FXML-files: TheLostPane, RulesPane,
 *       PlayerPaneController, ITheLostKitten, TheLostcontroller, IMap, MapView
 */

package Controller;

import Model.*;
import Model.Interfaces.IMap;
import Model.Interfaces.IPlayer;
import Model.Interfaces.ITheLostKitten;
import View.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class MainController{

    // Button, textfields etc are connected with the FXML file
    @FXML private Parent root;
    @FXML private DropShadow shadow = new DropShadow();

    @FXML private Button rulesButton = new Button();
    @FXML private Button startGameButton = new Button();
    @FXML private TextField playerTextField1, playerTextField2, playerTextField3, playerTextField4, playerTextField5, playerTextField6;
    @FXML private Label warningLabel;
    @FXML private Pane mapPlace;
    @FXML private VBox playerVBox;
    @FXML private FXMLLoader loader;
    @FXML private Stage stage;

    @FXML private Text rulesTextHeader = new Text();
    @FXML private Text rulesText = new Text("Varje gång det är din tur kan du förflytta dig antingen gratis via cykel eller genom att betala 3000kr via spårvagn. \n"
    + "Du kan på alla stationer vända en marker, om den inte redan är vänd\n" +
    "Man vinner spelet genom att hitta katten, eller genom att hitta spårvagnskortet om någon annan har hittat katten\n" +
            "och sen kommer först tillbaks till någon av startpunkterna.");
    @FXML private TextFlow textScrollPane;
    @FXML private Button backToStartButton = new Button();
    @FXML private Stage rulesStage = new Stage();

    private TheLostKittenController theLost;
    private TheLostKittenController newController;



    private List<IPlayer> players = new ArrayList<>();
    private ArrayList<PlayerPaneController> listOfPlayerPanes = new ArrayList<>();
    private ITheLostKitten newGame;
    private boolean hasSameName;
    private IMap map;


    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {
        //prepares the game board to be loaded, and viewed
        loader = new FXMLLoader(getClass().getResource("/theLostPane.fxml"));
        root = loader.load();
        theLost = loader.getController();
        theLost.setPlayersTurnLabel(playerTextField1.getText());
        theLost.setPayButtonDisable();
        theLost.setDiceButtonDisable();
        theLost.setTurnMarkerButtonDisable();
        stage = (Stage) startGameButton.getScene().getWindow();
        mapPlace = (AnchorPane)root.lookup("#mapPlace");
        playerVBox = (VBox)root.lookup("#playerPlace");


        //adds all players to a list
        addPlayers();

        newGame = new TheLostKitten(players);

        map = newGame.getMap();
        MapView mapView = new MapView(map,newGame);
        mapPlace.getChildren().add(mapView);
        AnchorPane.setTopAnchor(playerVBox, 10.0);
        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);

        checkSameName();
        canWePlay();
        startGame();

        newController = new TheLostKittenController(newGame, newGame.getDice(), listOfPlayerPanes,mapView);


    }

    private void addPlayers() throws IOException {
        if (!playerTextField1.getText().isEmpty()) {
            IPlayer player1  = new Player(playerTextField1.getText(), 5000);
            PlayerPaneController playerCon1 = new PlayerPaneController(player1);
            listOfPlayerPanes.add(playerCon1);
            players.add(player1);
            playerCon1.getView().setStyle(" -fx-background-color: thistle;");
            playerVBox.getChildren().add(playerCon1.getView());
        }

        if (!playerTextField2.getText().isEmpty()) {
            IPlayer player2  = new Player(playerTextField2.getText(), 5000);
            PlayerPaneController playerCon2 = new PlayerPaneController(player2);
            listOfPlayerPanes.add(playerCon2);
            players.add(player2);
            playerCon2.getView().setStyle(" -fx-background-color: seashell;");
            playerVBox.getChildren().add(playerCon2.getView());
        }

        if (!playerTextField3.getText().isEmpty()) {
            IPlayer player3  = new Player(playerTextField3.getText(), 5000);
            PlayerPaneController playerCon3 = new PlayerPaneController(player3);
            listOfPlayerPanes.add(playerCon3);
            players.add(player3);
            playerCon3.getView().setStyle(" -fx-background-color: aquamarine;");
            playerVBox.getChildren().add(playerCon3.getView());
        }

        if (!playerTextField4.getText().isEmpty()) {
            IPlayer player4  = new Player(playerTextField4.getText(), 5000);
            PlayerPaneController playerCon4 = new PlayerPaneController(player4);
            listOfPlayerPanes.add(playerCon4);
            players.add(player4);
            playerCon4.getView().setStyle(" -fx-background-color: cadetblue;");
            playerVBox.getChildren().add(playerCon4.getView());
        }

        if (!playerTextField5.getText().isEmpty()) {
            IPlayer player5  = new Player(playerTextField5.getText(), 5000);
            PlayerPaneController playerCon5 = new PlayerPaneController(player5);
            listOfPlayerPanes.add(playerCon5);
            players.add(player5);
            playerCon5.getView().setStyle(" -fx-background-color: yellowgreen;");
            playerVBox.getChildren().add(playerCon5.getView());
        }

        if (!playerTextField6.getText().isEmpty()) {
            IPlayer player6  = new Player(playerTextField6.getText(), 5000);
            PlayerPaneController playerCon6 = new PlayerPaneController(player6);
            listOfPlayerPanes.add(playerCon6);
            players.add(player6);
            playerCon6.getView().setStyle(" -fx-background-color: silver;");
            playerVBox.getChildren().add(playerCon6.getView());

         }

    }

    private void startGame() throws IOException {

        if(hasSameName && players.size()<2){
            warningLabel.setText("Alla spelare måste ha olika namn.");
        }

        if(!hasSameName && players.size()>1){
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }



    }

    private void canWePlay(){
        if(players.size()<2 || players.isEmpty()){
            warningLabel.setText("Det måste vara minst två spelare!");
            players.clear();
        }
        if(hasSameName){
            warningLabel.setText("Alla spelare måste ha olika namn.");
            players.clear();
        }
    }


    private void checkSameName(){
        for (int i = 0; i < players.size(); i++){
            for(int j = i+1; j < players.size(); j++) {
                hasSameName = players.get(i).getName().equals(players.get(j).getName());
                if(hasSameName){
                    players.clear();
                }
            }
        }
    }



    @FXML private void handleRulesGameButton(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Pane rulesPane = (Pane) loader.load(getClass().getResource("/rulesPane.fxml"));

        rulesTextHeader = (Text)rulesPane.lookup("#rulesTextHeader");
        rulesTextHeader.setText("Spelets regler");

        DropShadow textShadow = new DropShadow();
        textShadow.setRadius(5.0);
        textShadow.setOffsetX(3.0);
        textShadow.setOffsetY(3.0);
        textShadow.setColor(Color.color(0.4, 0.5, 0.5));
        rulesTextHeader.setEffect(textShadow);
        rulesText.setFont(Font.font("Comic Sans MS"));


        textScrollPane  = (TextFlow)rulesPane.lookup("#textScrollPane");
        textScrollPane.getChildren().add(rulesText);


        rulesStage.focusedProperty().addListener((obs, wasFocused, isNowFocused) -> {
            if (! isNowFocused) {
                rulesStage.hide();
            }
        });

        Scene scene = new Scene(rulesPane);
        rulesStage.setScene(scene);
        rulesStage.getScene().getRoot().setEffect(shadow);
        rulesStage.getScene().setFill(Color.TRANSPARENT);
        rulesStage.show();


    }






    @FXML
    private void setMouseEffect() {
        startGameButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                startGameButton.setEffect(shadow);
            }
        });

        startGameButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                startGameButton.setEffect(null);
            }
        });

        rulesButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                rulesButton.setEffect(shadow);
            }
        });

        rulesButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                rulesButton.setEffect(null);
            }
        });

        backToStartButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                backToStartButton.setEffect(shadow);
            }
        });

        backToStartButton.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                backToStartButton.setEffect(null);
            }
        });



    }


    public void handleBackToStartButton(ActionEvent actionEvent) {
        ((Node)(actionEvent.getSource())).getScene().getWindow().hide();

    }
}
