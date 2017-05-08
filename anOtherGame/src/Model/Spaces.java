package Model;


import Controller.SpaceController;
import sun.jvm.hotspot.memory.Space;

import java.util.ArrayList;

public class Spaces implements ISpace{
    private int y;
    private ArrayList<Spaces> adjacentSpaces;
    private Edge edge;
    private SpaceController controller;
    private int x;
    private Spaces space;


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

    public SpaceController getController() {
        return this.controller;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }

    public boolean compareSpaces(ISpace space){
        if(space == null)
            return false;
        return ((this.getX()==space.getX()) && (this.getY()==space.getY()));
    }

    public Spaces getSpace(){
        return space;
    }

}
