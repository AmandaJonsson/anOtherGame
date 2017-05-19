package Controller;

import Model.*;
import Model.Intefaces.IMap;
import Model.Intefaces.IPlayer;
import View.MapView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.effect.DropShadow;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by majanyberg on 2017-05-03.
 */
public class MainController {

    @FXML
    private Button rulesButton = new Button();
    @FXML
    private Button startGameButton = new Button();
    @FXML
    private Button backToStartButton = new Button();
    @FXML
    private TextField playerTextField1, playerTextField2,
            playerTextField3, playerTextField4, playerTextField5, playerTextField6;

    List<IPlayer> players = new ArrayList<>();
    ArrayList<PlayerPaneController> listOfPlayerPanes = new ArrayList<>();

    TheLostKitten newGame;

    private DropShadow shadow = new DropShadow();

    boolean hasSameName;
    boolean moreThanOnePlayer;

    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/View/TheLostPane.fxml"));
        Parent root = loader.load();

        TheLostController theLost = loader.getController();
        theLost.setPlayersTurnLabel(playerTextField1.getText());

        Stage stage = (Stage) startGameButton.getScene().getWindow();

        //MapController controller = new MapController(map, mapView);
        Pane mapPlace = (AnchorPane)root.lookup("#mapPlace");

        VBox playerVBox = (VBox)root.lookup("#playerPlace");;

        if (!playerTextField1.getText().isEmpty()) {
            Player player1  = new Player(playerTextField1.getText(), 5000);
            PlayerPaneController playerCon1 = new PlayerPaneController(player1);
            listOfPlayerPanes.add(playerCon1);
            players.add(player1);
            playerCon1.getView().setStyle(" -fx-background-color: thistle;");
            playerVBox.getChildren().add(playerCon1.getView());
        }

        if (!playerTextField2.getText().isEmpty()) {
            Player player2  = new Player(playerTextField2.getText(), 5000);
            PlayerPaneController playerCon2 = new PlayerPaneController(player2);
            listOfPlayerPanes.add(playerCon2);
            players.add(player2);
            playerCon2.getView().setStyle(" -fx-background-color: seashell;");
            playerVBox.getChildren().add(playerCon2.getView());
        }

        if (!playerTextField3.getText().isEmpty()) {
            Player player3  = new Player(playerTextField3.getText(), 5000);
            PlayerPaneController playerCon3 = new PlayerPaneController(player3);
            listOfPlayerPanes.add(playerCon3);
            players.add(player3);
            playerCon3.getView().setStyle(" -fx-background-color: aquamarine;");
            playerVBox.getChildren().add(playerCon3.getView());
        }

        if (!playerTextField4.getText().isEmpty()) {
            Player player4  = new Player(playerTextField4.getText(), 5000);
            PlayerPaneController playerCon4 = new PlayerPaneController(player4);
            listOfPlayerPanes.add(playerCon4);
            players.add(player4);
            playerCon4.getView().setStyle(" -fx-background-color: cadetblue;");
            playerVBox.getChildren().add(playerCon4.getView());
         }

        if (!playerTextField5.getText().isEmpty()) {
            Player player5  = new Player(playerTextField5.getText(), 5000);
            PlayerPaneController playerCon5 = new PlayerPaneController(player5);
            listOfPlayerPanes.add(playerCon5);
            players.add(player5);
            playerCon5.getView().setStyle(" -fx-background-color: yellowgreen;");
            playerVBox.getChildren().add(playerCon5.getView());
        }

        if (!playerTextField6.getText().isEmpty()) {
            Player player6  = new Player(playerTextField6.getText(), 5000);
            PlayerPaneController playerCon6 = new PlayerPaneController(player6);
            listOfPlayerPanes.add(playerCon6);
            players.add(player6);
            playerCon6.getView().setStyle(" -fx-background-color: silver;");
            playerVBox.getChildren().add(playerCon6.getView());
         }

        newGame = new TheLostKitten(players, listOfPlayerPanes);

        IMap map = newGame.getMap();
        MapView mapView = new MapView(map);
        mapPlace.getChildren().add(mapView);

        AnchorPane.setTopAnchor(playerVBox, 10.0); // obviously provide your own constraints

        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);

        checkSameName();

        if(hasSameName == true){
            System.out.println("Spelarna måste heta olika saker!");
        }


        //Sets the next view, if we get to play (enough players, different names)
        if(!hasSameName && players.size()>1){
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

        TheLostController newController = new TheLostController(newGame, newGame.getDice());


    }



    public void checkSameName(){
        for (int i = 0; i < players.size(); i++){
            for(int j = i+1; j < players.size(); j++) {
                System.out.println("*****111111******");
                System.out.println(players.get(i));
                System.out.println(players.get(j));
                System.out.println("*****222222******");
                hasSameName = players.get(i).getName().equals(players.get(j).getName());
                if(hasSameName){
                    players.clear();
           /*         playerTextField1.clear();
                    playerTextField2.clear();
                    playerTextField3.clear();
                    playerTextField4.clear();
                    playerTextField5.clear();
                    playerTextField6.clear();*/
                    System.out.println(hasSameName);
                }

            }
        }
    }

    @FXML protected void handleRulesGameButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) rulesButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Pane theLostPane = (Pane) loader.load(getClass().getResource("/View/rulesPane.fxml"));

        Scene scene = new Scene(theLostPane);
        stage.setScene(scene);
        stage.show();

    }

    @FXML protected void handleBackToStartButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) backToStartButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Pane theLostPane = (Pane) loader.load(getClass().getResource("/View/start.fxml"));
        Scene scene = new Scene(theLostPane);
        stage.setScene(scene);
        stage.show();

    }


    @FXML
    public void setMouseEffect() {
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
    }
}
