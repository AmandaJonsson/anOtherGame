package Objects;


import javafx.scene.paint.Paint;

public class Stations extends Spaces{
    public Stations(String name, int x, int y) {
        super(name, x, y);
        setRadius(15);
        setFill(Paint.valueOf("BLUE"));
    }
}
