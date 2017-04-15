package Objects;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import sun.jvm.hotspot.memory.Space;

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

    private boolean calculatePath(int x, int y) {
        //base case
        if (x == to.getX() && y== to.getY()){
            Spaces tmp = null;
            for (Step step :
                    path) {
                if (step instanceof Spaces){
                    if (tmp != null){
                        ((Spaces) step).addAdjacentSpace(tmp);
                    }
                    tmp = (Spaces)step;
                }

            }
            if (tmp != null){
                tmp.addAdjacentSpace(to);
            }

            return true;
        }
        // adds steps for the bicycle path
        if (((from.getX() - x)%10 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%10 == 0&& y!=from.getY() && y!=to.getY())){
            path.add(new Spaces("NONAME", x, y));

        }
        else path.add(new Path(x,y));
        if (x < to.getX()){
            if (y<to.getY()){
                return calculatePath(x+2,y+2);
            }
            if (y>to.getY()){
                return calculatePath(x+2,y-2);
            }
        }
        else if (x > to.getX()){
            if (y<to.getY()){
                return calculatePath(x-2,y+2);
            }
            if (y>to.getY()){
                return calculatePath(x+2,y-2);
            }
        }
        else if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(x,y+2);
            }
            if (y>to.getY()){
                return calculatePath(x,y-2);
            }
        }
        return false;
    }

    public ArrayList<Step> getPath() {
        return path;
    }
}
