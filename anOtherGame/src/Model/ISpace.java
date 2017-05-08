package Model;


import java.util.ArrayList;

public interface ISpace {
    public void addAdjacentSpace(Spaces space) ;
    public ArrayList<Spaces> getAdjacentSpaces();
    public Edge getEdge();
    public int getX();
    public int getY();
    public void setEdge(Edge edge);
    public boolean compareSpaces(ISpace space);
}
