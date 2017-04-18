package Objects;


import javafx.scene.paint.Paint;

public class Stations extends Spaces{
    public Stations(String name, int x, int y) {
        super("Blue", name, x, y);
        setRadius(8);
        setFill(Paint.valueOf("BLUE"));
    }
}
