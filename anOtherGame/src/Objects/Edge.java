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
        to.addAdjacentSpace(from);
        System.out.println(calculatePath(from, from.getX(),from.getY()));
    }

    private boolean calculatePath(Spaces prev, int x, int y) {
        //base case
        if (x == to.getX() && y== to.getY()){
            if(!to.getAdjacentSpaces().contains(prev)) {
                to.addAdjacentSpace(prev);
            }
            if(!prev.getAdjacentSpaces().contains(to)) {
                prev.addAdjacentSpace(to);
            }
            return true;
        }


        // adds steps for the bicycle path
        if (((from.getX() - x)%10 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%10 == 0&& y!=from.getY() && y!=to.getY())){
            Spaces space = new Spaces("NONAME", x, y);
            space.addAdjacentSpace(prev);
            prev.addAdjacentSpace(space);
            path.add(space);
            prev = space;
        }
        else path.add(new Path(x,y));
        if (x < to.getX()){
            if (y<to.getY()){
                return calculatePath(prev, x+2,y+2);
            }
            if (y>to.getY()){
                return calculatePath(prev, x+2,y-2);
            }
        }
        else if (x > to.getX()){
            if (y<to.getY()){
                return calculatePath(prev, x-2,y+2);
            }
            if (y>to.getY()){
                return calculatePath(prev, x+2,y-2);
            }
        }
        else if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(prev, x,y+2);
            }
            if (y>to.getY()){
                return calculatePath(prev, x,y-2);
            }
        }
        return false;
    }

    public ArrayList<Step> getPath() {
        return path;
    }
}
