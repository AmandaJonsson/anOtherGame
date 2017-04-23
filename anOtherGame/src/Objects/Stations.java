package Objects;


import javafx.scene.paint.Paint;

public class Stations extends Spaces{
    private String name;
    public Stations(Map map, String name, int x, int y) {
        super("blue", 10, x, y);
        this.name =  name;
        //setRadius(8);
        //setFill(Paint.valueOf("BLUE"));
        map.addSpaces(this);
    }

    public String getName() {
        return name;
    }

}
