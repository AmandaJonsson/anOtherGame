
import Objects.Player;
import javafx.application.Application;
import javafx.fxml.FXML;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.awt.event.ActionEvent;


public class TheLostKitten{

    @FXML Button startGameButton;
    @FXML Button rulesButton;
    @FXML TextField playerTextField1;
    @FXML TextField playerTextField2;
    @FXML TextField playerTextField3;
    @FXML TextField playerTextField4;
    @FXML TextField playerTextField5;
    @FXML TextField playerTextField6;



    @FXML
    private void pressedStartButtonAction (ActionEvent event){
        // Button was clicked, do something...
        Player player1 = new Player(playerTextField1.getText(), null, false, false, 5000);
        Player player2 = new Player(playerTextField2.getText(), null, false, false, 5000);
        Player player3 = new Player(playerTextField3.getText(), null, false, false, 5000);
        Player player4 = new Player(playerTextField4.getText(), null, false, false, 5000);
        Player player5 = new Player(playerTextField5.getText(), null, false, false, 5000);
        Player player6 = new Player(playerTextField6.getText(), null, false, false, 5000);

        System.out.println("Spelare 1 namn: " + player1.name + "Spelare 1 budget: " + player1.budget);
    }


    public TheLostKitten() {
             // Objects.Map map = new Objects.Map();
            //   Objects.Dice dice = new Objects.Dice();



    }


}
