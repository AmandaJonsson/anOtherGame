package Objects;

import java.util.Random;


public class MoneyMarker extends Marker {
    int n;
    private TypeOfMarkers marker;
    private int valueOfMarker;
    private Player player;
    private String [] descriptionText = {"Du har fått CSN","Du vann på lotto", "Du fick skatteåterbäring", "Du har fått pengar av mormor"};


    private int countTopaz;
    private int countEmerald;
    private int countRuby;
    private int countBlanc;


    public enum TypeOfMarkers{
        TOPAZ, EMERALD, RUBY, BLANK
    }

    public MoneyMarker(TypeOfMarkers marker) {
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
        switch(marker){
            case TOPAZ:
                valueOfMarker=3000;
                countTopaz--;
                String desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;

            case EMERALD:
                valueOfMarker=4000;
                countEmerald--;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;
            case RUBY:
                valueOfMarker = 5000;
                countRuby--;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker+ " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;
            case BLANK:
                valueOfMarker = 0;
                countBlanc--;
                desc = "";
                System.out.println(desc + " " + valueOfMarker+ " " + "kr");

        }

    }

}
