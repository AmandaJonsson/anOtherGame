package Model;


import Controller.SpaceController;

import java.util.ArrayList;

public interface ISpace {
    public void addAdjacentSpace(ISpace space) ;
    public ArrayList<ISpace> getAdjacentSpaces();
    public Edge getEdge();
    public int getX();
    public int getY();
    public void setEdge(Edge edge);
    public boolean compareSpaces(ISpace space);
    public SpaceController getController();
}
