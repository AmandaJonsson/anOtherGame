/*Authors: Maja
Responsibility: Handles the player panes
Used by: TheLostController
Uses: FXML-files:PlayerPane
 */

package Controller;

import Model.Intefaces.IPlayer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class PlayerPaneController {

    @FXML public Label nameLabel;
    @FXML public Label budgetLabel;
    @FXML ImageView theDiamond;
    @FXML ImageView tramCard;
    @FXML AnchorPane playerPane;


    public PlayerPaneController (IPlayer player) throws IOException {
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

    public void updateBudgetLabel(){
    }
}
