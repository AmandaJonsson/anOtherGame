package Objects;

/**
 * Created by amandajonsson on 2017-04-18.
 */
public class NotMoneyMarkers extends Markers {

    private NoMoneyMarkers marker;
    Player player = new Player(null, false, 0);
    private String foundTheCat = "Du hittade kattungen, bra jobbat!";
    private String foundTheTramCard = "Du hittade ett västtrafikkort";
    private String robedByAPickPocket= "Du har blivit rånad av en ficktjuv, han tog alla dina pengar";
    private  int pickpocket=0;

    public enum NoMoneyMarkers {
        CAT, TRAMCARD, PICKPOCKET
    }

    public NotMoneyMarkers(NoMoneyMarkers marker) {
        this.marker = marker;
        System.out.println("skapar en ny notmoneymarker");
    }

    @Override
    public void Markervalue() {
        switch (marker) {
            case CAT:
                player.hasCat();
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