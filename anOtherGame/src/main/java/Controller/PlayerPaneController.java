
/**
 * @author Maja
 * Revised by: Everybody
 * Responsibility: Handles one player pane.
 * Used by: TheLostKittenController
 * Uses: FXML-files: PlayerPane
 */


package Controller;

import Model.Interfaces.IPlayer;
import Model.Player;
import event.Event;
import event.EventBus;
import event.IEventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
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
        playerPane = FXMLLoader.load(getClass().getResource("/PlayerPane.fxml"));
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

    public ImageView getCatImage(){
        return theDiamond;
    }

    public ImageView getTramCardImage(){
        return tramCard;
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

        if(evt.getTag() == Event.Tag.PLAYER_TRAMCARD){
            Player pl = (Player)evt.getValue();
            if(pl.getName().equals(player.getName())){
                this.getTramCardImage().setVisible(true);

            }
        }

        if(evt.getTag() == Event.Tag.PLAYER_CAT){
            Player pla = (Player)evt.getValue();
            if(pla.getName().equals(player.getName())){
                this.getCatImage().setVisible(true);
            }
        }
    }



    private void initEvent() {
        EventBus.BUS.register(this);
    }


}
