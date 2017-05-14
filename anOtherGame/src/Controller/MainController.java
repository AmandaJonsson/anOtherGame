package Controller;

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
import javafx.scene.effect.DropShadow;


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

    TheLostController thelost;

    boolean hasSameName;
    boolean moreThanOnePlayer;
    ArrayList<String> players = new ArrayList<String>();

    //Creating textfields for the players budgets
    Label budgetLabel1 = new Label("BUDGET 1");
    Label budgetLabel2 = new Label("BUDGET 2");
    Label budgetLabel3 = new Label("BUDGET 3");
    Label budgetLabel4 = new Label("BUDGET 4");
    Label budgetLabel5 = new Label("BUDGET 5");
    Label budgetLabel6 = new Label("BUDGET 6");

    //Creating name labels for the players
    Label playerLabel1 = new Label();
    Label playerLabel2 = new Label();
    Label playerLabel3 = new Label();
    Label playerLabel4 = new Label();
    Label playerLabel5 = new Label();
    Label playerLabel6 = new Label();

    @FXML protected void handleStartGameButton(ActionEvent event) throws IOException {
        thelost=new TheLostController();

        Stage stage = (Stage) startGameButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setController(thelost);
        Parent root = loader.load(getClass().getResource("/View/TheLostPane.fxml"));


        Map map = new Map();
        MapView mapView = new MapView(map);
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

        AnchorPane.setTopAnchor(mapView, 0.0);
        AnchorPane.setLeftAnchor(mapView, 0.0);
        AnchorPane.setRightAnchor(mapView, 0.0);
        AnchorPane.setBottomAnchor(mapView, 0.0);


        mapPlace.getChildren().add(mapView);


        if (!playerTextField1.getText().isEmpty()) {
            players.add(playerTextField1.getText());
            playerVBox.getChildren().add(playerPane1);

            //adds name label to pane
            addNameLabeltoPane(playerPane1, playerLabel1);
            setLabelText(playerLabel1, playerTextField1.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane1, budgetLabel1);


        }

        if (!playerTextField2.getText().isEmpty()) {
            players.add(playerTextField2.getText());
            playerVBox.getChildren().add(playerPane2);

            //adds name label to pane
            addNameLabeltoPane(playerPane2, playerLabel2);
            setLabelText(playerLabel2, playerTextField2.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane2, budgetLabel2);


        }

        if (!playerTextField3.getText().isEmpty()) {
            players.add(playerTextField3.getText());
            playerVBox.getChildren().add(playerPane3);

            //adds name label to pane
            addNameLabeltoPane(playerPane3, playerLabel3);
            setLabelText(playerLabel3, playerTextField3.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane3, budgetLabel3);

        }

        if (!playerTextField4.getText().isEmpty()) {
            players.add(playerTextField4.getText());
            playerVBox.getChildren().add(playerPane4);

            //adds name label to pane
            addNameLabeltoPane(playerPane4, playerLabel4);
            setLabelText(playerLabel4, playerTextField4.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane4, budgetLabel4);

         }

        if (!playerTextField5.getText().isEmpty()) {
            players.add(playerTextField5.getText());
            playerVBox.getChildren().add(playerPane5);

            //adds name label to pane
            addNameLabeltoPane(playerPane5, playerLabel5);
            setLabelText(playerLabel5, playerTextField5.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane5, budgetLabel5);


        }

        if (!playerTextField6.getText().isEmpty()) {
            players.add(playerTextField6.getText());
            playerVBox.getChildren().add(playerPane6);

            //adds name label to pane
            addNameLabeltoPane(playerPane6, playerLabel6);
            setLabelText(playerLabel6, playerTextField6.getText());

            //adds budget label to pane
            addBudgetLabelToPane(playerPane6, budgetLabel6);

         }


        newGame = new TheLostKitten(players);
        TheLostController newController = new TheLostController(newGame);
        //newController.setPlayersTurnLabel();

        checkSameName();
        setBalance();
        if(moreThanOnePlayer == false){
            System.out.println("Minst två personer måste spela spelet!");
        }

        if(hasSameName == true){
            System.out.println("Spelarna måste heta olika saker!");
        }

        setBalance();


        thelost.setPlayersTurnLabel(playerTextField1.getText());

        System.out.println(thelost);
        System.out.println(thelost.playersTurnLabel.getText());

        //Sets the next view, if we get to play (enough players, different names)
        if(!hasSameName && players.size()>1){
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }

    }

    private void setLabelText(Label label, String text) {
        label.setText(text);
    }

    public void addBudgetLabelToPane(AnchorPane pane, Label label){
        pane.getChildren().addAll(label);
        label.setLayoutX(10);
        label.setLayoutY(40);
        label.setFont(new Font("Comic sans", 10));

    }

    public void addNameLabeltoPane(AnchorPane pane, Label label){
        pane.getChildren().addAll(label);
        label.setLayoutX(115);
        label.setLayoutY(20);
        label.setFont(new Font("Comic sans", 18));
    }

    public void checkSameName(){
        for (int i = 0; i < players.size(); i++){
            for(int j = i+1; j < players.size(); j++) {
                System.out.println("*****111111******");
                System.out.println(players.get(i));
                System.out.println(players.get(j));
                System.out.println("*****222222******");
                hasSameName = players.get(i).equals(players.get(j));
                if(hasSameName){
                    players.clear();
                    playerTextField1.clear();
                    playerTextField2.clear();
                    playerTextField3.clear();
                    playerTextField4.clear();
                    playerTextField5.clear();
                    System.out.println(hasSameName);
                }

            }
        }
    }

    public void setBalance(){
        // SETS THE BALANCES
        if(newGame.getPlayers().length == 1){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            moreThanOnePlayer = false;
        }

        if(newGame.getPlayers().length == 2){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            moreThanOnePlayer = true;
        }

        if(newGame.getPlayers().length == 3){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            moreThanOnePlayer = true;
        }
        if(newGame.getPlayers().length == 4){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
            moreThanOnePlayer = true;
        }
        if(newGame.getPlayers().length == 5){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
            budgetLabel5.setText(String.valueOf("Pengar: " + newGame.getPlayers()[4].getBalance() + " kr"));
            moreThanOnePlayer = true;
        }

        if(newGame.getPlayers().length == 6){
            budgetLabel1.setText(String.valueOf("Pengar: " + newGame.getPlayers()[0].getBalance() + " kr"));
            budgetLabel2.setText(String.valueOf("Pengar: " + newGame.getPlayers()[1].getBalance() + " kr"));
            budgetLabel3.setText(String.valueOf("Pengar: " + newGame.getPlayers()[2].getBalance() + " kr"));
            budgetLabel4.setText(String.valueOf("Pengar: " + newGame.getPlayers()[3].getBalance() + " kr"));
            budgetLabel5.setText(String.valueOf("Pengar: " + newGame.getPlayers()[4].getBalance() + " kr"));
            budgetLabel6.setText(String.valueOf("Pengar: " + newGame.getPlayers()[5].getBalance() + " kr"));
            moreThanOnePlayer = true;
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
