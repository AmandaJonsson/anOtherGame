package Objects;

import java.util.Random;

/**
 * Created by amandajonsson on 2017-04-06.
 */
public class MoneyMarkers extends Markers{

    private Markers marker;
    private int valueOfMarker;
    private Player player;
    private String [] descriptionText = {"Du har fått CSN","Du vann på lotto", "Du fick skatteåtebäring", "Du har fått pengar av mormor"};


    public enum Markers{
        TOPAZ, EMERALD, RUBY, BLANK
    }

    public MoneyMarkers(Markers marker) {
        this.marker = marker;
        System.out.println("Skapar en Moneymarker");
    }

    @Override
    public void Markervalue() {
        switch(marker){
            case TOPAZ:
                valueOfMarker=3000;
                String desc = (descriptionText[new Random().nextInt(descriptionText.length)]);
                System.out.println(desc + " " +  valueOfMarker + " " + "kr");
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
