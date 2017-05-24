/**
 * @author Amanda
 * Revised by: *name*
 * Responsibility: The logic behind the markers Cat, Tramcard and pickpocket.
 * Used by: Map
 * Uses: IMarker,
 */



package Model;
import Model.Intefaces.IMarker;

public class OtherMarkers extends Marker {


    private NoMoneyMarkers marker;
    public int pickpocket=0;
    public int countCat=0;
    public int countTramcard;


    //the different kinds of other markers
    public enum NoMoneyMarkers {
        CAT, TRAMCARD, PICKPOCKET
    }

    //get the marker type
    public NoMoneyMarkers getMarkerType(){
        return marker;
    }

    //constructor
    public OtherMarkers(NoMoneyMarkers marker) {
        this.marker = marker;
    }


    /* A method that returns the value of the marker which is either a tramcard, the cat
    or a pickpocket. If the marker is the cat the variable countCat sets to 1, the same with countTramCard.
     */
    @Override
    public int getMarkerValue(IMarker marker) {
        if (marker instanceof OtherMarkers){
            if(((OtherMarkers) marker).getMarkerType() == NoMoneyMarkers.TRAMCARD){
                countTramcard=1;
                return 1;
            }
            else if(((OtherMarkers) marker).getMarkerType() == NoMoneyMarkers.CAT){
                countCat=1;
                return 1;
            }
            else{
                return pickpocket;
            }
        }
        return 0;
    }
    
}