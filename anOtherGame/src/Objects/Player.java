package Objects;


public class Player {

    public Spaces position;
    public String name;
    public boolean hasTramCard = false;
    public int budget;      //StartBudget is 5000 kr right?
    public boolean hasCat = false;
    public boolean skipATurn = false;

    //fejk marker tills vi skrivit en funktion som heter getMarker
    private MoneyMarker marker = new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);


    public Player(String name, Spaces position, boolean hasTramCard, boolean hasCat, int budget, boolean skipATurn){
        this.name = name;
        this.position = position;
        this.hasTramCard = hasTramCard;
        this.budget = budget;
        this.hasCat = hasCat;
        this.skipATurn = skipATurn;
    }



    public int getBudget(){
        return this.budget;
    }

    public Spaces getPosition(){
        return this.position;
    }


    public void gotTramCard(){          //ska också ligga i  PlayerController?
        hasTramCard = true;
    }

    public void usedTramCard(){         //ska också ligga i PlayerController?
        hasTramCard = false;
    }

    public void hasCat(){
        hasCat = true;
    }


    public void updatePosition(Spaces newPosition){
        position = newPosition;

    }

    public void updateBudget(int value) {

        //marker  ==  this.position.getMarker()?
        if(marker.getClass().equals(MoneyMarker.class)){
            increaseBudget(value);
        } else if(marker.equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
            decreaseBudget(value);
        }

    }

    public int decreaseBudget(int value){
        return budget - value;
    }

    public int increaseBudget(int value){
        return budget + value;
    }

    public int payTicket(int ticket){
        return budget - ticket;
    }



}
