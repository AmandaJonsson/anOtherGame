package Objects;


public class Station extends Spaces{
    Markers marker;

    public Station(String name, int x, int y, Markers marker) {
        super(name, x, y);
        this.marker = marker;
    }

    
}