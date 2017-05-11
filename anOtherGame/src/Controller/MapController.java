package Controller;

import View.MapView;
import Model.*;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

/**
 * Created by Allex on 2017-04-06.
 */
public class MapController {
    private Map model;
    private MapView view;

    public MapController(Map model, MapView view) {
        this.model = model;
        this.view = view;
        addSpaces();
    }

    public void addSpaces(){
        model.createSpaces();
            ArrayList<Circle> list = new ArrayList<Circle>();
            for (ISpace space : model.getSpaces()) {
                //System.out.println(space.getController().getView());
                //System.out.println(space.getX() + " " + space.getY());
                view.add(space.getController().getView(), space.getX(), space.getY());
                if (space.getEdge() != null) {
                    for (Path path : space.getEdge().getPath()){
                       // System.out.println(path.getX() + " " + path.getY());
                        view.add(path, path.getX(), path.getY());
                    }
                }
            }
    }
}
