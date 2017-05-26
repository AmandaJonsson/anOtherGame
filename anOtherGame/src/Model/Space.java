/**
 * @author Allex
 * Revised by: *name*
 * Responsibility: The logic behind the spaces.
 * Used by:
 * Uses: ISpace
 */

package Model;

import Model.Intefaces.ISpace;

import java.util.ArrayList;

public class Space implements ISpace {
    private int y;
    private ArrayList<ISpace> adjacentSpaces;
    private int x;


    public Space(int x, int y) {
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public boolean compareSpaces(ISpace space){
        if(space == null)
            return false;
        return ((this.getX()==space.getX()) && (this.getY()==space.getY()));
    }

    @Override
    public String toString(){
        return getX() + "," + getY();
    }

}
