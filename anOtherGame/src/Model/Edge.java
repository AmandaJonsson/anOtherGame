package Model;

import java.util.ArrayList;

/**
 * Created by Allex on 2017-04-05.
 */
public class Edge {

    private ISpace from;
    private ISpace to;
    private ArrayList<Path> path;

    public Edge(Map map, ISpace from, ISpace to, String color) {
        this.from=from;
        this.to=to;
        path = new ArrayList<Path>();
        to.addAdjacentSpace(from);
        System.out.println(((Station)to).getName() + " " + ((Station)from).getName() + " " + calculatePath(map, from, from.getX(),from.getY(), color ));
    }

    private boolean calculatePath(Map map, ISpace prev, int x, int y, String color) {
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
        if (((from.getX() - x)%7 ==0 && x!=from.getX() && x!=to.getX()) || ((from.getY()-y)%7 == 0&& y!=from.getY() && y!=to.getY())){
            ISpace space = new Spaces(x, y);
            boolean exists = false;
            for(ISpace spacee : map.getSpaces()){
                if (spacee.getX()-x < 5 && spacee.getX()-x >-5 && spacee.getY()-y < 5 && spacee.getY()-y >-5){
                    System.out.println("jahaja");
                    space = spacee;
                    exists = true;
                }
            }
            space.addAdjacentSpace(prev);
            prev.addAdjacentSpace(space);
            if (!exists) {
                map.addSpaces(space);
            }else path.add(new Path(color, x,y));
            prev = space;
        }
        if (!(from.getX()-x < 1 && from.getX()-x >-1 && from.getY()-y <1 && from.getY()-y >-1) && !(to.getX()-x < 1 && to.getX()-x >-1 && to.getY()-y <1 && to.getY()-y >-1)) {
            path.add(new Path(color, x, y));
        }
        if (x < to.getX()){
            if (y==to.getY()){
                return calculatePath(map,prev,x+1, y, color);
            }
            if (y<to.getY()){
                return calculatePath(map, prev, x+1,y+1, color);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x+1,y-1, color);
            }
        }
         if (x > to.getX()){
             if (y==to.getY()){
                 return calculatePath(map,prev,x-1, y, color);
             }
            if (y<to.getY()){
                return calculatePath(map, prev, x-1,y+1, color);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x-1,y-1, color);
            }
        }
         if (x==to.getX()){
            if (y<to.getY()){
                return calculatePath(map, prev, x,y+1, color);
            }
            if (y>to.getY()){
                return calculatePath(map, prev, x,y-1, color);
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
