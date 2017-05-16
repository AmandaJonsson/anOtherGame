package Model;

import java.util.ArrayList;
import java.util.List;


public class MoneyMarker extends Marker{

    private TypeOfMarkers marker;
    private int valueOfMarker;
    private Player player;
    private Station station;
    private String [] descriptionText = {"Du har fått CSN","Du vann på lotto", "Du fick skatteåterbäring", "Du har fått pengar av mormor"};
    private String Guldheden = "Grattis! Du hittade en topas på Guldeheden, vilket ger dig 6000 kr";
    private String FirstPlayerToEmilsborg = "Du hann först till Emilsborg, du får 5000 kr";


    private int countTopaz=15;
    private int countEmerald=15;
    private int countRuby=15;
    private int countBlank=15;




    public enum TypeOfMarkers{
        TOPAZ, EMERALD, RUBY, BLANK
    }

    TypeOfMarkers type = TypeOfMarkers.TOPAZ;

    List<TypeOfMarkers> listOfMarker = new ArrayList<TypeOfMarkers>();


    public List<TypeOfMarkers> getListOfMarker() {
        return listOfMarker;
    }

    public void setListOfMarker(List<TypeOfMarkers> listOfMarker) {
        this.listOfMarker = listOfMarker;
    }


    public MoneyMarker(TypeOfMarkers marker) {
        this.marker = marker;

    }
    public TypeOfMarkers getMarkerType(){
        return marker;
    }

    @Override
    public int getMarkerValue(Marker marker) {
        if(marker instanceof MoneyMarker) {
            if (((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.TOPAZ) {
                return 3000;
            }

              else if(((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.EMERALD){
                   return 4000;
               }
                else if(((MoneyMarker) marker).getMarkerType() == TypeOfMarkers.RUBY){
                       return 5000;
                   }
            else {
                return 0;
            }
        }

        return 0;
    }


    public void specialMarkers(Marker marker, Station station){

        if (station.getName()=="Guldheden" && marker.equals(TypeOfMarkers.TOPAZ)){
            valueOfMarker = 6000;
            String desc = Guldheden;
            System.out.println(desc);
        }

        if (station.getName()=="Emilsborg" && marker.isMarkerTurned()==false){
            valueOfMarker = 5000;
            String desc = FirstPlayerToEmilsborg;

        }

    }



}
