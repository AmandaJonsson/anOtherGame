package Controller;


import Model.Player;
import Model.TheLostKitten;
import View.MapView;
import Model.Map;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;


import java.awt.*;
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

    TheLostKitten newGame;

    private DropShadow shadow = new DropShadow();

    theLostController thelost=new theLostController();

    //Creating textfields for the players budgets

    Label budgetLabel1 = new Label("BUDGET 1");
    Label budgetLabel2 = new Label("BUDGET 2");
    Label budgetLabel3 = new Label("BUDGET 3");
    Label budgetLabel4 = new Label("BUDGET 4");
    Label budgetLabel5 = new Label("BUDGET 5");
    Label budgetLabel6 = new Label("BUDGET 6");

    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {
     //  ActionEvent thisEvent = event;
        Stage stage = (Stage) startGameButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(thelost);
        Parent root = loader.load(getClass().getResource("/View/TheLostPane.fxml"));

        thelost.setPlayersTurnLabel(playerTextField1.getText());



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

        //Sets the background color on player pane
        playerPane1.setStyle(" -fx-background-color: thistle;");
        playerPane2.setStyle(" -fx-background-color: seashell;");
        playerPane3.setStyle(" -fx-background-color: aquamarine;");
        playerPane4.setStyle(" -fx-background-color: cadetblue;");
        playerPane5.setStyle(" -fx-background-color: yellowgreen;");
        playerPane6.setStyle(" -fx-background-color: silver;");

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

                //adds name label to pane
                playerPane1.getChildren().addAll(playerLabel1);
                playerLabel1.setLayoutX(115);
                playerLabel1.setLayoutY(20);
                playerLabel1.setText(playerTextField1.getText());
                playerLabel1.setFont(new Font("Comic sans", 18));


                //adds budget label to pane
                playerPane1.getChildren().addAll(budgetLabel1);
                budgetLabel1.setLayoutX(10);
                budgetLabel1.setLayoutY(40);
                budgetLabel1.setFont(new Font("Comic sans", 10));


            }

            if (!playerTextField2.getText().isEmpty()) {
                players.add(playerTextField2.getText());
                playerVBox.getChildren().add(playerPane2);

                //adds name label to pane
                playerPane2.getChildren().addAll(playerLabel2);
                playerLabel2.setLayoutX(115);
                playerLabel2.setLayoutY(20);
                playerLabel2.setText(playerTextField2.getText());
                playerLabel2.setFont(new Font("Comic sans", 18));

                //adds budget label to pane
                playerPane2.getChildren().addAll(budgetLabel2);
                budgetLabel2.setLayoutX(10);
                budgetLabel2.setLayoutY(40);
                budgetLabel2.setFont(new Font("Comic sans", 10));


            }

            if (!playerTextField3.getText().isEmpty()) {
                players.add(playerTextField3.getText());
                playerVBox.getChildren().add(playerPane3);

                //adds name label to pane
                playerPane3.getChildren().addAll(playerLabel3);
                playerLabel3.setLayoutX(115);
                playerLabel3.setLayoutY(20);
                playerLabel3.setText(playerTextField3.getText());
                playerLabel3.setFont(new Font("Comic sans", 18));

                //adds budget label to pane
                playerPane3.getChildren().addAll(budgetLabel3);
                budgetLabel3.setLayoutX(10);
                budgetLabel3.setLayoutY(40);
                budgetLabel3.setFont(new Font("Comic sans", 10));


            }

            if (!playerTextField4.getText().isEmpty()) {
                players.add(playerTextField4.getText());
                playerVBox.getChildren().add(playerPane4);

                //adds name label to pane
                playerPane4.getChildren().addAll(playerLabel4);
                playerLabel4.setLayoutX(115);
                playerLabel4.setLayoutY(20);
                playerLabel4.setText(playerTextField4.getText());
                playerLabel4.setFont(new Font("Comic sans", 18));

                //adds budget label to pane
                playerPane4.getChildren().addAll(budgetLabel4);
                budgetLabel4.setLayoutX(10);
                budgetLabel4.setLayoutY(40);
                budgetLabel4.setFont(new Font("Comic sans", 10));

            }

            if (!playerTextField5.getText().isEmpty()) {
                players.add(playerTextField5.getText());
                playerVBox.getChildren().add(playerPane5);

                //adds name label to pane
                playerPane5.getChildren().addAll(playerLabel5);
                playerLabel5.setLayoutX(115);
                playerLabel5.setLayoutY(20);
                playerLabel5.setText(playerTextField5.getText());
                playerLabel5.setFont(new Font("Comic sans", 18));

                //adds budget label to pane
                playerPane5.getChildren().addAll(budgetLabel5);
                budgetLabel5.setLayoutX(10);
                budgetLabel5.setLayoutY(40);
                budgetLabel5.setFont(new Font("Comic sans", 10));


            }

            if (!playerTextField6.getText().isEmpty()) {
                players.add(playerTextField6.getText());
                playerVBox.getChildren().add(playerPane6);

                //adds name label to pane
                playerPane6.getChildren().addAll(playerLabel6);
                playerLabel6.setLayoutX(115);
                playerLabel6.setLayoutY(20);
                playerLabel6.setText(playerTextField6.getText());
                playerLabel6.setFont(new Font("Comic sans", 18));

                //adds budget label to pane
                playerPane6.getChildren().addAll(budgetLabel6);
                budgetLabel6.setLayoutX(10);
                budgetLabel6.setLayoutY(40);
                budgetLabel6.setFont(new Font("Comic sans", 10));


            }

        boolean hasSameName = false;

        for (int i = 0; i < players.size(); i++){
            for(int j = i+1; j < players.size(); j++) {
                System.out.println("*****111111******");
                System.out.println(players.get(i));
                System.out.println(players.get(j));
                System.out.println("*****222222******");
                hasSameName = players.get(i).equals(players.get(j));
                if (hasSameName) {
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
        String player1 = playerTextField1.getText();
        System.out.println(player1);
        System.out.println(thelost);
        System.out.println(thelost.playersTurnLabel);

        //thelost.setPlayersTurnLabel(player1);

        newGame = new TheLostKitten(players);

        theLostController newController = new theLostController(newGame);
        //newController.setPlayersTurnLabel();


        if(newGame.getPlayers().length == 1){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
        }

        if(newGame.getPlayers().length == 2){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
        }

        if(newGame.getPlayers().length == 3){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
        }
        if(newGame.getPlayers().length == 4){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
        }
        if(newGame.getPlayers().length == 5){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
            budgetLabel5.setText(String.valueOf("Pengar: " + newGame.getPlayers()[4].getBalance() + " kr"));
        }

        if(newGame.getPlayers().length == 6){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
            budgetLabel5.setText(String.valueOf("Pengar: " + newGame.getPlayers()[4].getBalance() + " kr"));
            budgetLabel6.setText(String.valueOf("Pengar: " + newGame.getPlayers()[5].getBalance() + " kr"));
        }


        if(hasSameName == false){


            Scene scene = new Scene(root);

            stage.setScene(scene);
            stage.show();
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
