package Objects;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

/**
 * Created by Allex on 2017-04-05.
 */
public class Edge {

    private Spaces from;
    private Spaces to;
    private ArrayList<Step> path;

    public Edge(Spaces from, Spaces to) {
        this.from=from;
        this.to=to;
        path = new ArrayList<Step>();
        System.out.println(calculatePath(from.getX(),from.getY()));
    }

    /*private void calculatePath() {
        //if (from.getX()>to.getX()){
            for (int i = -1; i < from.getX()-to.getX(); i++){
                path.add(new Path(from.getX()-i,0));
            }
       // }

        for (int i = 0; i <= to.getX()-from.getX(); i++){
                if (i==5){
                    path.add(new Spaces("NONAME",from.getX() + i-1, from.getY()-1));
                }
                else if (i==15){
                    path.add(new Spaces("NONAME",from.getX() + i-1, from.getY()-1));
                }
                else if (i==25){
                    path.add(new Spaces("NONAME",from.getX() + i-1, from.getY()-1));
                }
                else if (i==35){
                    path.add(new Spaces("NONAME",from.getX() + i-1, from.getY()-1));
                }
            else path.add(new Path(from.getX() + i-1, from.getY()-1));
            if (i==  to.getX()-from.getX())
            for (int j = 0; j < to.getY()-from.getY(); j++) {
                if (j==5){
                    path.add(new Spaces("NONAME",from.getX() + i, from.getY() + j));
                }
                else if (j==15){
                    path.add(new Spaces("NONAME",from.getX() + i, from.getY() + j));
                }
                else if (j==25){
                    path.add(new Spaces("NONAME",from.getX() + i, from.getY() + j));
                }
                else if (j==35){
                    path.add(new Spaces("NONAME",from.getX() + i, from.getY() + j));
                }
                path.add(new Path(from.getX() + i-1, from.getY() + j));
            }
        }

        for (int i = 0; i <= from.getX()-to.getX(); i++){
            if (i==5){
                path.add(new Spaces("NONAME",from.getX() - i-1, from.getY()-1));
            }
            else if (i==15){
                path.add(new Spaces("NONAME",from.getX() - i-1, from.getY()-1));
            }
            else if (i==25){
                path.add(new Spaces("NONAME",from.getX() - i-1, from.getY()-1));
            }
            else if (i==35){
                path.add(new Spaces("NONAME",from.getX() - i-1, from.getY()-1));
            }
            else path.add(new Path(from.getX() - i-1, from.getY()-1));
            if (i==  from.getX()-to.getX())
                for (int j = 0; j < to.getY()-from.getY(); j++) {
                    if (j==5){
                        path.add(new Spaces("NONAME",from.getX() - i, from.getY() + j));
                    }
                    else if (j==15){
                        path.add(new Spaces("NONAME",from.getX() - i, from.getY() + j));
                    }
                    else if (j==25){
                        path.add(new Spaces("NONAME",from.getX() - i, from.getY() + j));
                    }
                    else if (j==35){
                        path.add(new Spaces("NONAME",from.getX() - i, from.getY() + j));
                    }
                    path.add(new Path(from.getX() - i-1, from.getY() + j));
                }
        }

    }*/
    private boolean calculatePath(int x, int y) {
        //base case
        if (x == to.getX() && y== to.getY()){
            return true;
        }
        // adds steps for the bicycle path
        if ((x%10 ==0 && x!=from.getX() && x!=to.getX()) || (y%10 == 0&& y!=from.getY() && y!=to.getY())){
            path.add(new Spaces("NONAME", x, y));
        }
        else path.add(new Path(x,y));
        if (x < to.getX()){
            if (y<to.getY()){
                return calculatePath(x+1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(x+1,y-1);
            }
        }
        else if (x > to.getX()){
            if (y<to.getY()){
                return calculatePath(x-1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(x+1,y-1);
            }
        }
        else if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(x,y+1);
            }
            if (y>to.getY()){
                return calculatePath(x,y-1);
            }
        }
        return false;
    }

    public ArrayList<Step> getPath() {
        return path;
    }
}
