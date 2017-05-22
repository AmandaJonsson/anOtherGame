package Model;


import Model.Intefaces.IPlayer;
import Model.Intefaces.ISpace;
import Model.Intefaces.IStation;
import event.Event;
import event.EventBus;

public class Player implements IPlayer {
    String name;
    ISpace position;
    int balance;
    private boolean hasTramCard = false;
    private boolean hasCat = false;
    private boolean skipATurn = false;
    private boolean isTurn = false;

    public Player(String name, ISpace position, int balance){
        this.name = name;
        this.position = position;
        this.balance = balance;

    }

    public Player(String name, int balance){
        this.name = name;
        this.balance = balance;
    }

    public boolean playerHasTurn(){
        return this.isTurn;
    }

    public int getBalance(){
        return this.balance;
    }

    public ISpace getPosition(){
        return this.position;
    }

    public void setTurn(){
        this.isTurn=true;
    }

    public void setNotTurn(){
        this.isTurn=false;
    }

    public String getName(){
        return this.name;
    }

    public void updatePosition(ISpace newPosition){
        setPosition(newPosition);
    }

    public void gotTramCard(){
        this.hasTramCard = true;
    }

    public void usedTramCard(){
        this.hasTramCard = false;
    }

    public boolean hasTramCard(){
        return this.hasTramCard;
    }

    public boolean hasCat(){
        return this.hasCat;
    }

    public void payTicket(int ticket){
        decreaseBalance(ticket);
    }

    public boolean getSkipATurn(){
        return this.skipATurn;
    }

    public void skipTurn(){
        this.skipATurn = true;
    }

    public void doneSkippingTurn(){
        this.skipATurn = false;
    }


    public int updateBudget() {

        //if the position is a station
        if(this.position instanceof Station){

            //if the station has a marker
            if(((IStation) this.position).hasMarker()){

                //if the marker is a MoneyMarker
                if (((IStation) this.position).getMarker().getClass().equals(MoneyMarker.class)) {
                    //konstig kod?
                    increaseBalance(((IStation) this.position).getMarker().getMarkerValue(((Station) this.position).getMarker()));
                
               /* //if the marker is a PickPocket
                }else if(((Station) this.position).getMarker().equals(OtherMarkers.NoMoneyMarkers.PICKPOCKET)){
                    robbedByPickpocket();*/
                }
            }
        }

        return balance;

    }

    // Event setters -----------------------
    public void setBalance(int balance) {
        this.balance = balance;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_BALANCE, this));
    }

    public void setPosition(ISpace position) {
        this.position = position;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_POSITION, this));
    }

    public void increaseBalance(int value){
        this.balance = this.balance + value;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_BALANCE, this));
    }

    public void decreaseBalance(int value){
        this.balance = this.balance - value;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_BALANCE, this));
    }

    public void robbedByPickpocket(){
        this.balance = 0;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_BALANCE, this));
    }



}
