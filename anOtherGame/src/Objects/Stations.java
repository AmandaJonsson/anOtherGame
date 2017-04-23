package Objects;


import javafx.scene.paint.Paint;

public class Stations extends Spaces{
    public Stations(Map map, String name, int x, int y) {
        super(name, x, y);
        //setRadius(8);
        //setFill(Paint.valueOf("BLUE"));
        map.addSpaces(this);
    }

}
