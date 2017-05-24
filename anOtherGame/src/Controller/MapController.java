
/**
 * @author Allex
 * Revised by: *name*
 * Responsibility: The controller to the Map.
 * Used by:
 * Uses: IMap, Mapview
 */


package Controller;

import Model.Intefaces.IMap;
import View.MapView;



public class MapController {
    private IMap model;
    private MapView view;

    public MapController(IMap model, MapView view) {
        this.model = model;
        this.view = view;
    }

}
