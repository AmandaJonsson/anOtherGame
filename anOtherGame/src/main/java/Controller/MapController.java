
/**
 * @author Allex
 * Revised by: *name*
 * Responsibility: The controller to the Map.
 * Used by:
 * Uses: IMap, Mapview
 */


package Controller;

import Model.Intefaces.ISpace;
import Model.Space;
import View.MapView;



public class MapController {
    private MapView view;
    private ISpace chosenSpace;

    public MapController(MapView view) {
        this.view = view;
    }

    public MapView getView(){
        return view;
    }

    public ISpace getChosenSpace(){
        chosenSpace = new Space(1,1);
        return chosenSpace;
    }


}
