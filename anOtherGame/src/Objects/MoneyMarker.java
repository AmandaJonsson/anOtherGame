package Objects;

import java.util.Random;


public class MoneyMarker extends Marker {
    int n;
    private TypeOfMarkers marker;
    private int valueOfMarker;
    private Player player;
    private String [] descriptionText = {"Du har fått CSN","Du vann på lotto", "Du fick skatteåtebäring", "Du har fått pengar av mormor"};


    public enum TypeOfMarkers{
        TOPAZ, EMERALD, RUBY, BLANK
    }

    public MoneyMarker(TypeOfMarkers marker) {
        this.marker = marker;
        System.out.println("Skapar en Moneymarker");
    }

    @Override
    public void Markervalue() {
        switch(marker){
            case TOPAZ:
                valueOfMarker=3000;
                String desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");
                //player.updateBudget(valueOfMarker);
                break;

            case EMERALD:
                valueOfMarker=4000;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker + " " + "kr");

                //player.updateBudget(valueOfMarker);
                break;
            case RUBY:
                valueOfMarker = 5000;
                desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " + valueOfMarker+ " " + "kr");

                //player.updateBudget(valueOfMarker);
                break;
            case BLANK:
                valueOfMarker = 0;
                desc = "";
                System.out.println(desc + " " + valueOfMarker+ " " + "kr");

        }

    }

}
