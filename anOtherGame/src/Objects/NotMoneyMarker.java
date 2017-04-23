package Objects;

/**
 * Created by amandajonsson on 2017-04-18.
 */
public class NotMoneyMarker extends Marker {

    private NoMoneyMarkers marker;
    Player player = new Player(null, null, false, false, 0);
    private String foundTheCat = "Du hittade kattungen, bra jobbat!";
    private String foundTheTramCard = "Du hittade ett västtrafikkort";
    private String robedByAPickPocket= "Du har blivit rånad av en ficktjuv, han tog alla dina pengar";
    private  int pickpocket=0;
    private int countCat=1;

    public enum NoMoneyMarkers {
        CAT, TRAMCARD, PICKPOCKET
    }

    public NotMoneyMarker(NoMoneyMarkers marker) {
        this.marker = marker;
        if (marker == NoMoneyMarkers.CAT){
            System.out.println("CAT");
        }
        if (marker == NoMoneyMarkers.PICKPOCKET){
            System.out.println("PICKPOCKET");
        }
    }

    @Override
    public void Markervalue() {
        switch (marker) {
            case CAT:
                countCat=0;
                System.out.println(foundTheCat);
                break;
            case TRAMCARD:
                player.gotTramCard();
                System.out.println(foundTheTramCard);
                break;
            case PICKPOCKET:
                //player.updateBudget(pickpocket);
                System.out.println(robedByAPickPocket);


        }
    }
}