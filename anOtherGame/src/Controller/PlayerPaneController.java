/*Authors: Maja
Responsibility: Handles the player panes
Used by: TheLostController
Uses: FXML-files:PlayerPane
 */

package Controller;

import Model.Intefaces.IPlayer;
import Model.Marker;
import Model.OtherMarkers;
import Model.Player;
import event.Event;
import event.EventBus;
import event.IEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

import java.io.IOException;

public class PlayerPaneController implements IEventHandler {

    @FXML public Label nameLabel;
    @FXML public Label budgetLabel;
    @FXML ImageView theDiamond;
    @FXML ImageView tramCard;
    @FXML AnchorPane playerPane;
    private IPlayer player;



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
        initEvent();
        this.player = player;

    }

    public AnchorPane getView(){
        return playerPane;
    }

    public IPlayer getPlayer(){
        return player;
    }

    //Method if we would like to also indicate the panel of the active player!
    //Right now some kind of shadow, he he he he
    @Override
    public void onEvent(Event evt) {
        if(evt.getTag()==Event.Tag.LOSTKITTEN_NEXT){
            Player p = (Player)evt.getValue();
            if(p.getName().equals(player.getName())){
                this.getView().setEffect(new DropShadow(20, Color.BLACK));
            }else{
                this.getView().setEffect(null);
            }
        }
    }



    private void initEvent() {
        EventBus.BUS.register(this);
    }


}
