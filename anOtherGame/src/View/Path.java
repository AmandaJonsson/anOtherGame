package View;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;


public class Path extends Circle{
    private int x;
    private int y;

    public Path(String color, int x, int y) {
        this.x=x;
        this.y=y;
        this.setFill(Paint.valueOf(color));
        this.setRadius(2);

        this.centerYProperty();
    }


    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}
