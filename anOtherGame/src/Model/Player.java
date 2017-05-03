package Model;


public class Player {

    private Spaces position;
    private String name;
    private int balance;
    private boolean hasTramCard = false;
    private boolean hasCat = false;
    private boolean skipATurn = false;

    //fejk marker tills vi skrivit en funktion som heter getMarker
    private MoneyMarker marker = new MoneyMarker(MoneyMarker.TypeOfMarkers.BLANK);


    public Player(String name, Spaces position, int balance){
        this.name = name;
        this.position = position;
        this.balance = balance;
        //this.hasTramCard = hasTramCard;   -> should be false at start?
        //this.hasCat = hasCat;             -> should be false at start?
        //this.skipATurn = skipATurn;       -> should be false at start?
    }

    public int getBalance(){
        return balance;
    }

    public Spaces getPosition(){
        return position;
    }

    public String getName(){
        return name;
    }

    public void updatePosition(Spaces newPosition){
        position = newPosition;
    }

    public void gotTramCard(){
        hasTramCard = true;
    }

    public void usedTramCard(){
        hasTramCard = false;
    }

    public boolean hasTramCard(){
        return hasTramCard;
    }

    public void hasCat(){
        hasCat = true;
    }

    public void robbedByPickpocket(){
        balance = 0;
    }

    public void increaseBalance(int value){
        balance = balance + value;
    }

    public void decreaseBalance(int value){
        balance = balance - value;
    }

    public void payTicket(int ticket){
        decreaseBalance(ticket);
    }

    public boolean getSkipATurn(){
        return skipATurn;
    }

    public void skipTurn(){
        skipATurn = true;
    }

    public void doneSkippingTurn(){
        skipATurn = false;
    }

    public void updateBudget(int value) {
        //marker  ==  this.position.getMarker()?
        if(marker.getClass().equals(MoneyMarker.class)){
            increaseBalance(value);
        } else if(marker.equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
            decreaseBalance(value);
        }

    }

}
