package Objects;

import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 * Created by Allex on 2017-04-05.
 */
public class Path extends Circle{
    private int x;
    private int y;

    public Path(int x, int y) {
        this.x=x;
        this.y=y;
        this.setFill(Paint.valueOf("RED"));
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
