package Controller;

import Model.Intefaces.IMap;
import View.MapView;
import Model.*;
import javafx.scene.shape.Circle;

import java.util.ArrayList;


public class MapController {
    private IMap model;
    private MapView view;

    public MapController(IMap model, MapView view) {
        this.model = model;
        this.view = view;
    }

}
