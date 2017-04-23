package Objects;


import Controllers.SpaceController;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

import java.util.ArrayList;

public class Spaces{
    private int y;
    private ArrayList<Spaces> adjacentSpaces;
    private Edge edge;
    private SpaceController controller;
    private int x;


    public Spaces(int x, int y) {
        this.x= x;
        this.y = y;
        this.adjacentSpaces = new ArrayList<Spaces>();
        controller = new SpaceController(this);

    }

    public Spaces(String color, int radius, int x, int y) {
        this.x= x;
        this.y = y;
        this.adjacentSpaces = new ArrayList<Spaces>();
        controller = new SpaceController(this);
        controller.setColor(color);
        controller.setRadius(radius);
    }

    public void addAdjacentSpace(Spaces space) {
        adjacentSpaces.add(space);
    }

    public ArrayList<Spaces> getAdjacentSpaces() {
        return adjacentSpaces;
    }


    public Edge getEdge() {
        return edge;
    }

    public void addPath(Map map, Stations station) {
        if(edge != null ){
            edge.addEdge(new Edge(map, this, station));
        }
        else {
            edge = new Edge(map, this, station);
        }
        adjacentSpaces.add(station);
    }

    public SpaceController getController() {
        return this.controller;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
