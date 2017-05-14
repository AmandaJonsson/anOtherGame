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
    }

}
