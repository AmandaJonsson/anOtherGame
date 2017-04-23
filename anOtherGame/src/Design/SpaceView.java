package Design;

import Controllers.SpaceController;
import Objects.Spaces;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

/**
 * Created by Allex on 2017-04-23.
 */
public class SpaceView extends Circle {
    private String color;
    private SpaceController controller;

    public SpaceView(SpaceController controller, String color) {
        this.color = color;
        this.controller=controller;
        this.setId("spaces");
        this.setFill(Paint.valueOf(color));
        this.setRadius(5);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        this.setFill(Paint.valueOf(color));
    }
}
