package View;

import Model.Intefaces.ISpace;
import Model.Player;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

public class PlayerPiece extends Circle{
    private ISpace positionOfPlayer;
    private String color;

    public PlayerPiece(Player player, String color) {
        positionOfPlayer = player.getPosition();
        this.color = color;
        this.setFill(Paint.valueOf(color));
        this.setRadius(10);
        this.centerYProperty();
    }

    public ISpace getPosition(){
        return positionOfPlayer;
    }

    public void setColorOfPiece(String newColor){
        color = newColor;
    }


}

