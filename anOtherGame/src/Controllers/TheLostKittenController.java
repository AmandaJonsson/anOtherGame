package Controllers;

import Objects.Player;
import Objects.TheLostKitten;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;

public class TheLostKittenController {

    TheLostKitten lostKitten = new TheLostKitten();

    @FXML private TextField playerTextField1;
    @FXML private TextField playerTextField2;
    @FXML private TextField playerTextField3;
    @FXML private TextField playerTextField4;
    @FXML private TextField playerTextField5;
    @FXML private TextField playerTextField6;

    @FXML private Button rulesButton;

    @FXML private Button startGameButton;


    Player player1 = new Player(playerTextField1.getText(), null, false, false, 5000);
    Player player2 = new Player(playerTextField2.getText(), null, false, false, 5000);
    Player player3 = new Player(playerTextField3.getText(), null, false, false, 5000);
    Player player4 = new Player(playerTextField4.getText(), null, false, false, 5000);
    Player player5 = new Player(playerTextField5.getText(), null, false, false, 5000);
    Player player6 = new Player(playerTextField6.getText(), null, false, false, 5000);


    //Starta skärmen
    //ta hand om
    @FXML
    private void pressedStartButtonAction (ActionEvent event){
        // Button was clicked, do something...

        System.out.println("Spelare 1 namn: " + player1.name + "Spelare 1 budget: " + player1.budget);
    }



}
