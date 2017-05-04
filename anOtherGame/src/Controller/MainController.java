package Controller;

import Model.TheLostKitten;
import View.MapView;
import Model.Map;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
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

    @FXML
    private Label nameLabel2;

    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {
        Stage stage = (Stage) startGameButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        Parent root = loader.load(getClass().getResource("/View/TheLostPane.fxml"));
        VBox playerPlace = (VBox)root.lookup("#playerPlace");

        Map map = new Map();
        MapView mapView = new MapView();
        MapController controller = new MapController(map, mapView);
        Pane mapPlace = (AnchorPane)root.lookup("#mapPlace");

        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));


        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);


        mapPlace.getChildren().add(mapView);

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();


        ArrayList<String> players = new ArrayList<String>();

        if(!playerTextField1.getText().isEmpty()){
            players.add(playerTextField1.getText());
        }

        if(!playerTextField2.getText().isEmpty()){
            players.add(playerTextField2.getText());
        }

        if(!playerTextField3.getText().isEmpty()){
            players.add(playerTextField3.getText());
        }

        if(!playerTextField4.getText().isEmpty()){
            players.add(playerTextField4.getText());
        }

        if(!playerTextField5.getText().isEmpty()){
            players.add(playerTextField5.getText());
        }

        if(!playerTextField6.getText().isEmpty()){
            players.add(playerTextField6.getText());
        }

        TheLostKitten newGame = new TheLostKitten(players);

    }

    /*Parent root = FXMLLoader.load(getClass().getResource("/View/theLostPane.fxml"));
        primaryStage.setTitle("The Lost Kitten");
        AnchorPane.setTopAnchor(root, 0.0);
        AnchorPane.setLeftAnchor(root, 0.0);
        AnchorPane.setRightAnchor(root, 0.0);
        AnchorPane.setBottomAnchor(root, 0.0);
        AnchorPane pane = new AnchorPane();
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        Map map = new Map();
        MapView mapView = new MapView();
        MapController controller = new MapController(map, mapView);
        Pane mapPlace = (AnchorPane)root.lookup("#mapPlace");
        VBox playerPlace = (VBox)root.lookup("#playerPlace");
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        playerPlace.getChildren().add(FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml")));
        //mapPlace.getChildren().add(mapView);
        //pane.getChildren().add(mapView);
        pane.getChildren().add(root);
        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);
        mapPlace.getChildren().add(mapView);
        primaryStage.show();*/






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
