/**
 * @author Maja
 * Revised by: *name*
 * Responsibility: The logic behind the players.
 * Used by:
 * Uses: ISpace
 */

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
    private boolean robbedByPickpocket= false;

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
        if(this.position instanceof Station){
            if(((IStation) this.position).hasMarker()){
                if (((IStation) this.position).getMarker().getClass().equals(MoneyMarker.class)) {
                    increaseBalance(((IStation) this.position).getMarker().getMarkerValue(((Station) this.position).getMarker()));

                }
                else if(((IStation) this.position).getMarker().getClass().equals(OtherMarkers.class)){
                    if(((IStation) this.position).getMarker().equals( OtherMarkers.NoMoneyMarkers.CAT)){
                        increaseBalance(0);
                    }
                }
            }
        }

        return this.balance;

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

    public boolean robbedByPickpocket(){
        robbedByPickpocket=true;
        this.balance = 0;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_BALANCE, this));
        return robbedByPickpocket;
    }
    public boolean gotTramCard(){
        this.hasTramCard = true;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_TRAMCARD, this));
        return hasTramCard;
    }

    public boolean setHasCat(){
        hasCat=true;
        EventBus.BUS.publish(new Event(Event.Tag.PLAYER_CAT, this));
        return hasCat;
    }


}
