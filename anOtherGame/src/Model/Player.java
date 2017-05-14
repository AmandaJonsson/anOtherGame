package Model;


import Model.Intefaces.IPlayer;

public class Player implements IPlayer {

    Space position;
    String name;
    int balance;
    private boolean hasTramCard = false;
    private boolean hasCat = false;
    private boolean skipATurn = false;
    boolean isTurn = false;

    public Player(String name, Space position, int balance){
        this.name = name;
        this.position = position;
        this.balance = balance;

    }

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public boolean playerHasTurn(){
        return isTurn;
    }

    public int getBalance(){
        return balance;
    }

    public Space getPosition(){
        return position;
    }

    public void setPosition(Space position){
        this.position = position;
    }

    public String getName(){
        return name;
    }

    public void updatePosition(Space newPosition){
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

        //if the position is a station
        if(this.position instanceof Station){

            //if the station has a marker
            if(((Station) this.position).hasMarker()){

                //if the marker is a MoneyMarker
                if (((Station) this.position).getMarker().getClass().equals(MoneyMarker.class)) {
                    increaseBalance(value);
                
                //if the marker is a PickPocket
                }else if(((Station) this.position).getMarker().equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
                    robbedByPickpocket();
                }
            }
        }


    }

}
