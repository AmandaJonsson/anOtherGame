package Model;



import java.util.ArrayList;

public class Spaces implements ISpace{
    private int y;
    private ArrayList<ISpace> adjacentSpaces;
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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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
