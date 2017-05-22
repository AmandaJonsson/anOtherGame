package View;

import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.Player;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PlayerPiece extends Circle{
    private IPlayer player;
    private ISpace positionOfPlayer;
    private String color;
    private String name;

    public PlayerPiece(IPlayer player, String color) {
        this.player = player;
        positionOfPlayer = player.getPosition();
        this.color = color;
        this.setFill(Paint.valueOf(color));
        this.setRadius(10);
        this.centerYProperty();
    }

    public ISpace getPosition(){
        return positionOfPlayer;
    }

    public void setPositionOfPlayer(int x, int y){
        positionOfPlayer = player.getPosition();
    }

    public void setColorOfPiece(String newColor){
        color = newColor;
    }

    public IPlayer getPlayer(){
        return player;
    }

}
