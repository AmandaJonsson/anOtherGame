package Controllers;

import Design.MapView;
import Objects.*;

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
        ArrayList<Step> list = new ArrayList<Step>();
        list.addAll(model.getSpaces());
        for (Spaces space : model.getSpaces()){
            for (Edge edge : space.getAdjacentSpaces()) {
                list.addAll(edge.getPath());
            }
        }
        for (Step step : list) {
            view.addSpaces(step);
        }
    }
}
