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
        calculatePath();
    }

    private void calculatePath() {
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

    }

    public ArrayList<Step> getPath() {
        return path;
    }
}
