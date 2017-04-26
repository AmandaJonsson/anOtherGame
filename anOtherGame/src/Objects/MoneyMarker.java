package Objects;

import Controllers.PlayerController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;


public class MoneyMarker extends Marker {

    private TypeOfMarkers marker;
    private int valueOfMarker;
    private PlayerController player;
    private Station station;
    private String [] descriptionText = {"Du har fått CSN","Du vann på lotto", "Du fick skatteåterbäring", "Du har fått pengar av mormor"};
    private String Guldheden = "Grattis! Du hittade en topas på Guldeheden, vilket ger dig 6000 kr";
    private String FirstPlayerToEmilsborg = "Du hann först till Emildborg, du får 5000 kr";


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
       // this.station = station;
        this.marker = marker;
        if(marker == TypeOfMarkers.TOPAZ){
            System.out.println("TOPAZ");
        }
        if(marker == TypeOfMarkers.EMERALD){
            System.out.println("EMERALD");
        }
        if(marker == TypeOfMarkers.RUBY){
            System.out.println("RUBY");
        }
        if(marker == TypeOfMarkers.BLANK){
            System.out.println("BLANK");
        }
    }

    @Override
    public void Markervalue() {
        switch (marker) {
            case TOPAZ:
                valueOfMarker = 3000;
                countTopaz--;
                String desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;

            case EMERALD:
                valueOfMarker = 4000;
                countEmerald--;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;

            case RUBY:
                valueOfMarker = 5000;
                countRuby--;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;
            case BLANK:
                valueOfMarker = 0;
                countBlank--;
                desc = "";
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                break;
        }
    }

    public void specialMarkers(Marker marker, Station station){

        if (station.getName()=="Guldheden" && marker.equals(TypeOfMarkers.TOPAZ)){
            valueOfMarker = 6000;
            String desc = Guldheden;
            //player.updateBudget(valueOfMarker);
            System.out.println(desc);
        }

        if (station.getName()=="Emilsborg" && marker.isMarkerTurned()==false){
            valueOfMarker = 5000;
            //player.updateBudget(valueOfMarker);
            String desc = FirstPlayerToEmilsborg;

        }

    }

}
