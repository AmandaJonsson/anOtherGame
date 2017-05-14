package Controller;

import Model.Player;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;
import java.util.Random;

/**
 * Created by majanyberg on 2017-05-14.
 */
public class PlayerPaneController {

    @FXML Label nameLabel;
    @FXML Label budgetLabel;
    @FXML ImageView theDiamond;
    @FXML ImageView tramCard;
    @FXML AnchorPane playerPane;



    public PlayerPaneController (Player player) throws IOException {

        playerPane = FXMLLoader.load(getClass().getResource("/View/PlayerPane.fxml"));
        nameLabel = (Label)playerPane.lookup("#nameLabel");
        nameLabel.setText(player.getName());
        budgetLabel = (Label)playerPane.lookup("#budgetLabel");
        budgetLabel.setText(String.valueOf("Pengar: " + player.getBalance()) + " kr");
        theDiamond = (ImageView)playerPane.lookup("#theDiamond");
        theDiamond.setVisible(false);
        tramCard = (ImageView)playerPane.lookup("#tramCard");
        tramCard.setVisible(false);


    }



    public AnchorPane getView(){
        return playerPane;
    }


}
