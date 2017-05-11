package Model;


import Controller.SpaceController;
import sun.jvm.hotspot.memory.Space;

import java.util.ArrayList;

public class Spaces implements ISpace{
    private int y;
    private ArrayList<ISpace> adjacentSpaces;
    private Edge edge;
    private SpaceController controller;
    private int x;


    public Spaces(int x, int y) {
        this.x= x;
        this.y = y;
        this.adjacentSpaces = new ArrayList<ISpace>();
        controller = new SpaceController(this);
    }

    public Spaces(String color, int radius, int x, int y) {
        this.x= x;
        this.y = y;
        this.adjacentSpaces = new ArrayList<ISpace>();
        controller = new SpaceController(this);
        controller.setColor(color);
        controller.setRadius(radius);
    }

    public void addAdjacentSpace(ISpace space) {
        adjacentSpaces.add(space);
    }

    public ArrayList<ISpace> getAdjacentSpaces() {
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

    public String toString(){
        return getX() + "," + getY();
    }
}
