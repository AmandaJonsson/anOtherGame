package Model;

import Model.Intefaces.*;
import event.Event;
import event.EventBus;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TheLostKitten implements ITheLostKitten{
    IMap map;
    Dice dice;
    private List<IPlayer> playerList;
    private IPlayer activePlayer;
    
    public TheLostKitten(List<IPlayer> nameOfPlayers) {
        map = new Map();
        dice = new Dice();
        playerList = nameOfPlayers;
        nameOfPlayers.get(0).setTurn();

        for(IPlayer player : nameOfPlayers){
            player.setPosition(getRandomStartPosition());
        }
        activePlayer = nameOfPlayers.get(0);
    }

    public List<IPlayer> getListOfPlayers(){
        return playerList;
    }
    public IMap getMap(){
        return map;
    }

    public IDice getDice(){
        return dice;
    }

    public IPlayer getActivePlayer(){
        return activePlayer;
    }

    public void setActivePlayer(IPlayer player){
        activePlayer = player;
    }

    public ISpace getRandomStartPosition(){
        map.getStartPositions();
        ArrayList<ISpace> startpositions = new ArrayList<ISpace>();
        for (int i=0; i<map.getStartPositions().size(); i++){
            startpositions.add(map.getStartPositions().get(i));
        }
        Random r = new Random();
        int startPos = r.nextInt(2);
        return startpositions.get(startPos);
    }

    public void setNewBudget() {
        IMarker mark = ((Station) getActivePlayer().getPosition()).getMarker();
        if (mark instanceof MoneyMarker) {
            System.out.println(getActivePlayer().getName() + " " + getActivePlayer().getPosition() + " " + getActivePlayer().getBalance());
            System.out.println(((MoneyMarker) mark).getMarkerType() + " " + mark.getMarkerValue(mark));
            getActivePlayer().updateBudget();
        }
    }

    public void setNewDecreasedBudget(int value){
        getActivePlayer().decreaseBalance(value);
    }


    public List<IPlayer> getPlayers(){
        return playerList;
    }

    public void moveByBike(int resultFromDice){
        FindPath.findPotentialSpaces(resultFromDice, getActivePlayer().getPosition());
        System.out.println(getActivePlayer().getPosition());
        System.out.println(resultFromDice);
        System.out.println(FindPath.findPotentialSpaces(resultFromDice, getActivePlayer().getPosition()));
    }

    public void moveByTram(int resultFromDice){
        FindPath.findPotentialSpaces(resultFromDice, getActivePlayer().getPosition());

    }

    public void moveByBoat(int resultFromDice){
        FindPath.findPotentialSpaces(resultFromDice, getActivePlayer().getPosition());
    }

    public void move(){
        System.out.println("NU är det spelare " + getActivePlayer().getName());
    }

    //----Event setters-------------
    public void getNextPlayer(){
        int indexInListOfPlayers = getListOfPlayers().indexOf(activePlayer);
        if(indexInListOfPlayers==playerList.size()-1) {
            activePlayer = playerList.get(0);
        }else {
            activePlayer = playerList.get(indexInListOfPlayers + 1);
        }
        EventBus.BUS.publish(new Event(Event.Tag.LOSTKITTEN_NEXT, activePlayer));
    }

}



