package Objects;

import javafx.fxml.FXML;

import java.awt.event.ActionEvent;
import java.util.LinkedList;


public class TheLostKitten{

    private LinkedList<Player> PlayerList = new LinkedList<>();

    public TheLostKitten() {

        Objects.Map map = new Objects.Map();

        Objects.Dice dice = new Objects.Dice();

    }

    public void addPlayer(Player player){
        PlayerList.add(player);
    }












}
