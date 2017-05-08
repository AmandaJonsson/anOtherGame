package Controller;

import Model.TheLostKitten;
import View.MapView;
import Model.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;

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



    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {
        ActionEvent thisEvent = event;
        Stage stage = (Stage) startGameButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/View/TheLostPane.fxml"));

        Map map = new Map();
        MapView mapView = new MapView();
        MapController controller = new MapController(map, mapView);
        Pane mapPlace = (AnchorPane)root.lookup("#mapPlace");

        VBox playerVBox = (VBox)root.lookup("#playerPlace");;

        AnchorPane.setTopAnchor(playerVBox, 10.0); // obviously provide your own constraints

        //Creating all the player panes
        AnchorPane playerPane1 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        AnchorPane playerPane2 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        AnchorPane playerPane3 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        AnchorPane playerPane4 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        AnchorPane playerPane5 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        AnchorPane playerPane6 =FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));

        //Creating name labels for the players
        Label playerLabel1 = new Label();
        Label playerLabel2 = new Label();
        Label playerLabel3 = new Label();
        Label playerLabel4 = new Label();
        Label playerLabel5 = new Label();
        Label playerLabel6 = new Label();

        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);


        mapPlace.getChildren().add(mapView);

        ArrayList<String> players = new ArrayList<String>();




            if (!playerTextField1.getText().isEmpty()) {
                players.add(playerTextField1.getText());
                playerVBox.getChildren().add(playerPane1);
                playerPane1.getChildren().addAll(playerLabel1);
                playerLabel1.setLayoutX(115);
                playerLabel1.setLayoutY(20);
                playerLabel1.setText(playerTextField1.getText());
                playerLabel1.setFont(new Font("Comic sans", 15));

            }

            if (!playerTextField2.getText().isEmpty()) {
                players.add(playerTextField2.getText());
                playerVBox.getChildren().add(playerPane2);
                playerPane2.getChildren().addAll(playerLabel2);
                playerLabel2.setLayoutX(115);
                playerLabel2.setLayoutY(20);
                playerLabel2.setText(playerTextField2.getText());
                playerLabel2.setFont(new Font("Comic sans", 15));

            }

            if (!playerTextField3.getText().isEmpty()) {
                players.add(playerTextField3.getText());
                playerVBox.getChildren().add(playerPane3);
                playerPane3.getChildren().addAll(playerLabel3);
                playerLabel3.setLayoutX(115);
                playerLabel3.setLayoutY(20);
                playerLabel3.setText(playerTextField3.getText());
                playerLabel3.setFont(new Font("Comic sans", 15));

            }

            if (!playerTextField4.getText().isEmpty()) {
                players.add(playerTextField4.getText());
                playerVBox.getChildren().add(playerPane4);
                playerPane4.getChildren().addAll(playerLabel4);
                playerLabel4.setLayoutX(115);
                playerLabel4.setLayoutY(20);
                playerLabel4.setText(playerTextField4.getText());
                playerLabel4.setFont(new Font("Comic sans", 15));

            }

            if (!playerTextField5.getText().isEmpty()) {
                players.add(playerTextField5.getText());
                playerVBox.getChildren().add(playerPane5);
                playerPane5.getChildren().addAll(playerLabel5);
                playerLabel5.setLayoutX(115);
                playerLabel5.setLayoutY(20);
                playerLabel5.setText(playerTextField5.getText());
                playerLabel5.setFont(new Font("Comic sans", 15));

            }

            if (!playerTextField6.getText().isEmpty()) {
                players.add(playerTextField6.getText());
                playerVBox.getChildren().add(playerPane6);
                playerPane6.getChildren().addAll(playerLabel6);
                playerLabel6.setLayoutX(115);
                playerLabel6.setLayoutY(20);
                playerLabel6.setText(playerTextField6.getText());
                playerLabel6.setFont(new Font("Comic sans", 15));

            }

        boolean hasSameName = false;


        for (int i = 0; i < players.size(); i++){
            for(int j = i+1; j < players.size(); j++){
                System.out.println("*****111111******");
                System.out.println(players.get(i));
                System.out.println(players.get(j));
                System.out.println("*****222222******");
                hasSameName = players.get(i).equals(players.get(j));
                if(hasSameName) {
                    System.out.println("Alla spelare måste ha olika namn!");
                    players.clear();
                    playerTextField1.clear();
                    playerTextField2.clear();
                    playerTextField3.clear();
                    playerTextField4.clear();
                    playerTextField5.clear();
                    playerTextField6.clear();
                    System.out.println(players);

                }


            }


        }

        if(hasSameName == false){
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


        TheLostKitten newGame = new TheLostKitten(players);
//        theLostController newController = new theLostController(newGame);

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



}
