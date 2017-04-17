package Objects;

import javafx.scene.Node;
import javafx.scene.shape.*;
import javafx.scene.shape.Shape;

import java.awt.*;

/**
 * Created by Allex on 2017-04-06.
 */
public class Step extends Circle{
    private int x;
    private int y;
    private String name;

    public Step(String name, int x, int y) {
        this.x=x;
        this.y=y;
        this.name = name;
    }

    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }
    public String getName() {
        return name;
    }

}
