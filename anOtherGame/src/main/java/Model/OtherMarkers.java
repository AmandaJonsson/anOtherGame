/**
 * @author Amanda
 * Revised by: Everybody.
 * Responsibility: The logic behind the markers Cat, Tramcard and pickpocket.
 * Used by: Map, Player, TheLostKitten
 * Uses: Marker,IMarker
 */



package Model;
import Model.Intefaces.IMarker;

public class OtherMarkers extends Marker {


    private NoMoneyMarkers marker;
    public int pickpocket=0;
    public int countCat=0;
    public int countTramcard;
    private int markervalue;


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


    @Override
    public int getMarkerValue(IMarker marker) {
        return 0;
    }

    /* A method that returns the value of the marker which is either a tramcard, the cat
        or a pickpocket. If the marker is the cat the variable countCat sets to 1, the same with countTramCard.
         */
    @Override
    public void getOtherMarkerValue(IMarker marker) {
        if (marker instanceof OtherMarkers){
            if(((OtherMarkers) marker).getMarkerType() == NoMoneyMarkers.TRAMCARD){
                countTramcard=1;
            }
            else if(((OtherMarkers) marker).getMarkerType() == NoMoneyMarkers.CAT){
                countCat=1;
            }
            else if(((OtherMarkers) marker).getMarkerType() == NoMoneyMarkers.PICKPOCKET){
                pickpocket=0;
            }
        }

    }
    
}