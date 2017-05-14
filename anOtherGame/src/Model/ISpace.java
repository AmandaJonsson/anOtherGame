package Model;


import Controller.SpaceController;

import java.util.ArrayList;

public interface ISpace {
    public void addAdjacentSpace(ISpace space) ;
    public ArrayList<ISpace> getAdjacentSpaces();
    public int getX();
    public int getY();
    public boolean compareSpaces(ISpace space);
}
