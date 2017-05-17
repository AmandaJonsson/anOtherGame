package Model;

/**
 * Created by amandajonsson on 2017-04-18.
 */
public class OtherMarkers extends Marker {

    private NoMoneyMarkers marker;
    Player player = new Player(null, null, 0);
    private String foundTheCat = "Du hittade kattungen, bra jobbat!";
    private String foundTheTramCard = "Du hittade ett västtrafikkort";
    private String robedByAPickPocket= "Du har blivit rånad av en ficktjuv, han tog alla dina pengar";
    private  int pickpocket=0;
    private int countCat=1;
    private int countTramcard;



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
        if (marker == NoMoneyMarkers.CAT){
            System.out.println("CAT");
        }
        if (marker == NoMoneyMarkers.PICKPOCKET){
            System.out.println("PICKPOCKET");
        }
    }


    /* A method that returns the value of the marker which is either a tramcard, the cat
    or a pickpocket. If the marker is the cat the variable countCat sets to 1, the same with countTramCard.
     */
    @Override
    public int getMarkerValue(Marker marker) {
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
                return 0;
            }
        }
        return 0;
    }
    
}