package Model;

import Model.Intefaces.IMarker;

import java.util.ArrayList;
import java.util.List;


public class MoneyMarker extends Marker {

    private TypeOfMarkers marker;
    private String[] descriptionText = {"Du har fått CSN", "Du vann på lotto", "Du fick skatteåterbäring", "Du har fått pengar av mormor"};

    //The different kinds of markers that contains money
    public enum TypeOfMarkers {
        TOPAZ, EMERALD, RUBY, BLANK
    }

    List<TypeOfMarkers> listOfMarker = new ArrayList<TypeOfMarkers>();


    public List<TypeOfMarkers> getListOfMarker() {
        return listOfMarker;
    }

    public void setListOfMarker(List<TypeOfMarkers> listOfMarker) {
        this.listOfMarker = listOfMarker;
    }


    //Constructor
    public MoneyMarker(TypeOfMarkers marker) {
        this.marker = marker;

    }

    //get the marker type
    public TypeOfMarkers getMarkerType() {
        return marker;
    }

    /* Returns the value of a specific marker, depending on if it is a Topaz,
    Emerald, Ruby or Blank.
     */
    @Override
    public int getMarkerValue(IMarker marker) {
        if (marker instanceof MoneyMarker) {
            if (((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.TOPAZ) {
                return 3000;
            } else if (((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.EMERALD) {
                return 4000;
            } else if (((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.RUBY) {
                return 5000;
            } else {
                return 0;
            }
        }
        return 0;
    }

    /* A method that handle the special markers, for example you get twice as much
    money if you get a Topaz on Guldheden. And the first player who gets to Emilsborg
    gets 5000 kr.
     */

    public int specialMarkers(Marker marker, Station station) {
        if (marker instanceof MoneyMarker) {

            if (((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.TOPAZ && station.getName() == "Guldheden") {
                return 6000;
            }

            if (station.getName() == "Emilsborg" && marker.isMarkerTurned() == false) {
                return 5000;
            }

        }
        return 0;
    }
}
