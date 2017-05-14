package Model;



import java.util.ArrayList;

public class Spaces implements ISpace{
    private int y;
    private ArrayList<ISpace> adjacentSpaces;
    private Edge edge;
    private int x;


    public Spaces(int x, int y) {
        this.x= x;
        this.y = y;
        this.adjacentSpaces = new ArrayList<ISpace>();
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
