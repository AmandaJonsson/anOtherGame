package Objects;

import sun.jvm.hotspot.memory.Space;

import java.util.ArrayList;

/**
 * Created by Allex on 2017-04-05.
 */
public class Edge {

    private Spaces from;
    private Spaces to;
    private ArrayList<Path> path;

    public Edge(Map map, Spaces from, Spaces to) {
        this.from=from;
        this.to=to;
        path = new ArrayList<Path>();
        to.addAdjacentSpace(from);
        System.out.println(calculatePath(map, from, from.getX(),from.getY()));
    }

    private boolean calculatePath(Map map, Spaces prev, int x, int y) {
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
            boolean exists = false;
            for(Spaces spacee : map.getSpaces()){
                if (spacee.getX()==x && spacee.getY()==y){
                    System.out.println("jahaja");
                    space = spacee;
                    exists = true;
                }
            }
            space.addAdjacentSpace(prev);
            prev.addAdjacentSpace(space);
            if (!exists) {
                map.addSpaces(space);
            }
            prev = space;
        }
        else path.add(new Path(x,y));
        if (x < to.getX()){
            if (y<to.getY()){
                return calculatePath(map, prev, x+1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x+1,y-1);
            }
        }
         if (x > to.getX()){
            if (y<to.getY()){
                return calculatePath(map, prev, x-1,y+1);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x+1,y-1);
            }
        }
         if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(map, prev, x,y+1);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x,y-1);
            }
        }
        return false;
    }

    public ArrayList<Path> getPath() {
        return path;
    }

    public void addEdge(Edge edge) {
        path.addAll(edge.getPath());
    }
}
